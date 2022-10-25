package ro.tuc.ds2020.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.services.admin_user_management.UserCrudService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user-crud")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserCrudController {
    @Autowired
    private UserCrudService userCrudService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCrudController.class);

    @DeleteMapping("/delete-user/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteUser(@PathVariable Long id) {
        LOGGER.info(String.format("REQUEST - /deleteClient, for id %d",
                id));
        userCrudService.deleteUser(id);
    }

    @PutMapping("/update-user")
    @ResponseStatus(HttpStatus.OK)
    void updateUser(@Valid @RequestBody UserDTO userDTO) {
        LOGGER.info(String.format("REQUEST - /updateUser, for id %d",
                userDTO.getId()));
        userCrudService.updateUser(userDTO);
    }

    @GetMapping("/get-all-clients")
    @ResponseStatus(HttpStatus.OK)
    List<UserDTO> getAllClients() {
        LOGGER.info("REQUEST - /get-all-clients");
        return userCrudService.getAllClients();
    }

    @GetMapping("/get-all-users")
    @ResponseStatus(HttpStatus.OK)
    List<UserDTO> getAllUserss() {
        LOGGER.info("REQUEST - /get-all-users");
        return userCrudService.getAllUsers();
    }
}
