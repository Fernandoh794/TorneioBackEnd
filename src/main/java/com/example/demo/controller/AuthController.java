package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.LoginSuccessResponseMessage;
import com.example.demo.model.LoginUserRequestBody;
import com.example.demo.model.RegisterUserRequestBody;
import com.example.demo.model.ResponseMessage;
import com.example.demo.service.AuthService;
import com.example.demo.service.HttpRequestService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
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
}
