package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserCurrentMessage {

    private final String firstName;
    private final String lastName;
    private final String email;

    private final boolean success;

    public UserCurrentMessage(Boolean success, String firstName, String lastName, String email) {
        this.success = success;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
