package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.*;
import com.example.demo.service.AuthService;
import com.example.demo.service.HttpRequestService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpRequestService httpRequestService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> registerUser(@RequestBody RegisterUserRequestBody requestBody, final HttpServletRequest request) {
        User user = authService.registerUser(
                requestBody.getFirstName(),
                requestBody.getLastName(),
                requestBody.getEmail(),
                requestBody.getPassword()
        );


        return ResponseEntity.ok().body(new ResponseMessage(true));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginSuccessResponseMessage> loginUser(@RequestBody LoginUserRequestBody requestBody) {
        String token = authService.loginUser(requestBody.getEmail(), requestBody.getPassword());
        User user = (User) userService.loadUserByUsername(requestBody.getEmail());

        return ResponseEntity.ok().body(new LoginSuccessResponseMessage(
                true,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                token
        ));
    }



    @GetMapping("/user/current")
    public ResponseEntity<UserCurrentMessage> verifyUserLoggedCurrent(@AuthenticationPrincipal User user) {
        if (user != null) {
            UserCurrentMessage message = new UserCurrentMessage(
                    true,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail()
            );
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }




}
