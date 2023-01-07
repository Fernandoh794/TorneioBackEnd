package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ErrorResponseMessage extends ResponseMessage {

    private final String message;

    public ErrorResponseMessage(boolean success, String message) {
        super(success);
        this.message = message;
    }
}
