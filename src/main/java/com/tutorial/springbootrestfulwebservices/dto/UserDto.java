package com.tutorial.springbootrestfulwebservices.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    @NotEmpty(message = "firstname should not be null or empty")
    private String firstName;

    @NotEmpty(message = "lastname should not be null or empty")
    private String lastName;

    @Email(message = "email should should be valid")
    @NotEmpty(message = "email should not be null or empty")
    private String email;
}
