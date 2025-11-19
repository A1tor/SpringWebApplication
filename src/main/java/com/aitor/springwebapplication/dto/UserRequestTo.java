package com.aitor.springwebapplication.dto;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestTo {
    private long id;

    @NotBlank(message = "Login is required")
    @Size(min = 2, max = 64, message = "Login must be between 2 and 64 characters")
    private String login;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
    private String password;

    @NotBlank(message = "Firstname is required")
    @Size(min = 2, max = 64, message = "Firstname must be between 2 and 64 characters")
    private String firstname;

    @NotBlank(message = "Lastname is required")
    @Size(min = 2, max = 64, message = "Lastname must be between 2 and 64 characters")
    private String lastname;
}