package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create;

import jakarta.validation.constraints.*;

public class UserRequest {




    @Email(message = "the email must be a valid email")
    private String email;

    @NotBlank(message = "the username is required")
    @Size(
            max = 100,
            message = "the username must be less than 100 characters"
    )
    private String name;


    @NotBlank(message = "the password is required")
    @Size(
            max = 20,
            min = 8,
            message = "the password must be between 8 and 20 characters"
    )
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$).{8,20}$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and no whitespace"
    )
    private String password;

    @NotNull(message = "the active field is required")
    private Boolean active;
}
