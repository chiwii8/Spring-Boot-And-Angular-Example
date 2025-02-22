package app.controller;

import app.entity.UserAccount;
import app.entity.UserDTO;
import app.service.UserDetailsServiceCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET,RequestMethod.POST})
public class UserAccountController {

    private final UserDetailsServiceCustom userDetailsServiceCustom;
    private final Logger logger = LoggerFactory.getLogger(UserAccountController.class);

    @Autowired
    public UserAccountController(UserDetailsServiceCustom userDetailsServiceCustom) {
        this.userDetailsServiceCustom = userDetailsServiceCustom;
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        List<UserAccount> userAccounts = userDetailsServiceCustom.findAll();

        return userAccounts.stream().map(user -> new UserDTO(user.getUsername(),user.getPassword(),user.isActive()))
                .collect(Collectors.toList());
    }

    @PostMapping("/users")
    public void addUser(@RequestBody UserDTO userDTO){
        UserAccount userAccount = new UserAccount(userDTO.getUsername(), userDTO.getPassword());
        userDetailsServiceCustom.save(userAccount);
    }
}