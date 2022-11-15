package ro.tuc.webapp.services.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.AccessRoleRequiredException;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.AuthenticationRequiredException;
import ro.tuc.webapp.entities.Admin;
import ro.tuc.webapp.entities.Client;
import ro.tuc.webapp.entities.User;
import ro.tuc.webapp.repositories.AdminRepository;
import ro.tuc.webapp.repositories.ClientRepository;
import ro.tuc.webapp.repositories.UserRepository;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    public User getCurrentUser(String resource) throws AuthenticationRequiredException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName =
                ((UserDetailsServiceImpl.UserDetailsImpl) auth.getPrincipal()).getUsername();
        Optional<User> optUser =
                userRepository.findByUserName(userName);
        if (optUser.isEmpty()) {
            LOGGER.warn("User tried to access resource without being authenticated");
            throw new AuthenticationRequiredException(resource, userName);
        }
        return optUser.get();
    }

    public Admin getCurrentAdmin(String resource) throws AccessRoleRequiredException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Admin> optUser =
                adminRepository.findByUserName(((UserDetailsServiceImpl.UserDetailsImpl) auth.getPrincipal()).getUsername());
        if (optUser.isEmpty()) {
            LOGGER.warn("Non-Admin User tried to access Admin-Only resources.");
            throw new AccessRoleRequiredException(resource, "ADMIN");
        }
        return optUser.get();
    }

    public Client getCurrentClient(String resource) throws AccessRoleRequiredException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<Client> optUser =
                clientRepository.findByUserName(((UserDetailsServiceImpl.UserDetailsImpl) auth.getPrincipal()).getUsername());
        if (optUser.isEmpty()) {
            LOGGER.warn("Non-Client User tried to access Student-Only resources.");
            throw new AccessRoleRequiredException(resource, "CLIENT");
        }
        return optUser.get();
    }
}
