package com.aiquizgenerator.backend.account.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAccountDto {
    @NotBlank(message = "A sub is required")
    private String sub;

    @NotBlank(message = "Username cannot be blank")
    @Size(max = 50, message = "Username can be at most 50 characters")
    private String username;

    public String getSub() {
        return sub;
    }

    public String getUsername() {
        return username;
    }
}
