package ro.tuc.ds2020.services.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.DuplicateUsernameException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.InvalidLoginException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.NoAccessToDataException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.NoRightToModifyDataException;
import ro.tuc.ds2020.dtos.LoginJwtDTO;
import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.ClientRepository;
import ro.tuc.ds2020.repositories.UserRepository;
import ro.tuc.ds2020.services.authentication.jwt.JwtUtils;
import ro.tuc.ds2020.services.rightverifier.RightVerifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.System.exit;

/**
 * Service that implements functionalities related to user authentication: registration.
 */
@Service
public class LoginRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRegistrationService.class);

    public void register(NewUserDTO userDTO) throws DuplicateUsernameException {
        // check that username is not taken
        Optional<User> userWithSameName = userRepository.findByUserName(userDTO.getUserName());
        if (userWithSameName.isPresent()) {
            LOGGER.info(String.format("INVALID UPDATE - Failed registration: %s name already " +
                    "taken.", userDTO.getUserName()));
            throw new DuplicateUsernameException(userDTO.getUserName(), userDTO.getUserName());
        }

        // save new user
        User user = UserFactory.buildUser(userDTO, passwordEncoder);

        LOGGER.info(String.format("UPDATE - new user registered with name %s.",
                user.getUserName()));
        userRepository.save(user);
    }

    public ResponseEntity<LoginJwtDTO> login(UserDTO userDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDTO.getUserName(),
                            userDTO.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsServiceImpl.UserDetailsImpl userDetails = (UserDetailsServiceImpl.UserDetailsImpl) authentication.getPrincipal();

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new LoginJwtDTO(
                    userDetails.getUsername(),
                    roles.get(0),
                    jwt)); // todo: assumed just 1 role
        } catch (BadCredentialsException e) {
            throw new InvalidLoginException(userDTO.toString());
        }
    }
}
