package com.tutorial.springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User dto model informations"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    @Schema(
            description = "user first name"
    )
    @NotEmpty(message = "firstname should not be null or empty")
    private String firstName;

    @Schema(
            description = "user last name"
    )
    @NotEmpty(message = "lastname should not be null or empty")
    private String lastName;

    @Schema(
            description = "user email address"
    )
    @Email(message = "email should should be valid")
    @NotEmpty(message = "email should not be null or empty")
    private String email;
}
