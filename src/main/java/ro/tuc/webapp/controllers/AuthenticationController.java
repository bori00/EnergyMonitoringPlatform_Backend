package ro.tuc.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.DuplicateUsernameException;
import ro.tuc.webapp.dtos.NewUserDTO;
import ro.tuc.webapp.dtos.UserDTO;
import ro.tuc.webapp.services.authentication.LoginRegistrationService;
import ro.tuc.webapp.services.authentication.jwt.JwtUtils;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private LoginRegistrationService loginRegistrationService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    void register(@Valid @RequestBody NewUserDTO userDTO) throws DuplicateUsernameException {
        LOGGER.info(String.format("REQUEST - /register, for username %s",
                userDTO.getUserName()));
        loginRegistrationService.register(userDTO);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        LOGGER.info(String.format("REQUEST - /login, for username %s",
                userDTO.getUserName()));

        return loginRegistrationService.login(userDTO);
    }
}
