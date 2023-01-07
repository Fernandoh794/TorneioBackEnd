package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.UserResponseMessage;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseMessage>> fetchAllUsers() {
        List<User> users = userService.fetchAllUsers();

        List<UserResponseMessage> modifiedUsers = users.stream()
                .map((user -> new UserResponseMessage(
                        true,
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail()
                )))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(modifiedUsers);
    }

    @GetMapping("/user/current")
    public ResponseEntity<UserResponseMessage> fetchCurrentAuthenticatedUser(Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        return ResponseEntity.ok().body(new UserResponseMessage(
                true,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        ));
    }
}
