package com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.UserUpdateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequest extends UserUpdateRequest {
    @NotBlank(message = "the role is required")
    @Pattern(regexp = "ADMIN|STRUDENT|INSTRUCTOR", message = "The state must be ADMIN, STUDENT or INSTRUCTOR")
    private String role;
}
