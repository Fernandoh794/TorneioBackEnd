package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseMessage {
    private final boolean success;
}
