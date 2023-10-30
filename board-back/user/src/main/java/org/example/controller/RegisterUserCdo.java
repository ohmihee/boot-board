package org.example.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserCdo {
    private String name;
    private String userId;
    private String password;
}
