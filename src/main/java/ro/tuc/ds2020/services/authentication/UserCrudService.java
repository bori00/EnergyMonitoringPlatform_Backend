package ro.tuc.ds2020.services.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.DuplicateUsernameException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.NoRightToModifyDataException;
import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.builders.UserBuilder;
import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.AdminRepository;
import ro.tuc.ds2020.repositories.ClientRepository;
import ro.tuc.ds2020.repositories.UserRepository;
import ro.tuc.ds2020.services.authentication.jwt.JwtUtils;
import ro.tuc.ds2020.services.rightverifier.RightVerifier;

import java.util.Optional;

@Service
public class UserCrudService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRegistrationService.class);

    public void deleteUser(Long userId) {

        User currentUser = authenticationService.getCurrentUser("DeleteClient");

        // find the user whose data is to be deleted
        Optional<User> optUserToDelete = userRepository.findById(userId);
        if (optUserToDelete.isEmpty()) {
            throw new ResourceNotFoundException(String.format("User with ID %d", userId));
        }
        User userToDelete = optUserToDelete.get();

        // check that the current user has the right to modify the requested user's data
        if (!new RightVerifier().hasRightToModifyTheDataOf(currentUser, userToDelete)) {
            throw new NoRightToModifyDataException(String.format("User with ID %d", userId));
        }

        userRepository.delete(userToDelete);
        LOGGER.info(String.format("DELETE - user with name %s.",
                userToDelete.getUserName()));
    }

    public void updateUser(UserDTO userDTO) {

        User currentUser = authenticationService.getCurrentUser("DeleteClient");

        // find the user whose data is to be updated
        Optional<User> optExistingUser = userRepository.findById(userDTO.getId());
        if (optExistingUser.isEmpty()) {
            throw new ResourceNotFoundException(String.format("User with ID %d", userDTO.getId()));
        }
        User userToUpdate = optExistingUser.get();

        // check that the current user has the right to modify the requested user's data
        if (!new RightVerifier().hasRightToModifyTheDataOf(currentUser, userToUpdate)) {
            throw new NoRightToModifyDataException(String.format("User with ID %d",
                    userToUpdate.getId()));
        }

        // check that username is not taken
        Optional<User> userWithSameName = userRepository.findByUserName(userDTO.getUserName());
        if (userWithSameName.isPresent() && !userWithSameName.get().equals(userToUpdate)) {
            LOGGER.info(String.format("INVALID UPDATE - Failed registration: %s name already " +
                    "taken by another user.", userDTO.getUserName()));
            throw new DuplicateUsernameException(userDTO.getUserName(), userDTO.getUserName());
        }

        // update user data
        UserBuilder.updateDataFrom(userToUpdate, userDTO);

        // save new user
        userRepository.save(userToUpdate);

        LOGGER.info(String.format("UPDATE - user %s's data updated",
                userToUpdate.getUserName()));
    }
}
