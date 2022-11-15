package ro.tuc.webapp.services.admin_user_management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.tuc.webapp.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.DuplicateUsernameException;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.NoRightToModifyDataException;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.SelfDeletionException;
import ro.tuc.webapp.dtos.UserDTO;
import ro.tuc.webapp.dtos.builders.UserBuilder;
import ro.tuc.webapp.entities.User;
import ro.tuc.webapp.repositories.ClientRepository;
import ro.tuc.webapp.repositories.UserRepository;
import ro.tuc.webapp.services.authentication.AuthenticationService;
import ro.tuc.webapp.services.authentication.LoginRegistrationService;
import ro.tuc.webapp.services.authentication.jwt.JwtUtils;
import ro.tuc.webapp.services.rightverifier.RightVerifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserCrudService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

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

        if (currentUser.getId().equals(userId)) {
            throw new SelfDeletionException("userId");
        }

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

    public List<UserDTO> getAllClients() {
        return clientRepository.findAll().stream().map(UserBuilder::toDTO).collect(Collectors.toList());
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserBuilder::toDTO).collect(Collectors.toList());
    }
}
