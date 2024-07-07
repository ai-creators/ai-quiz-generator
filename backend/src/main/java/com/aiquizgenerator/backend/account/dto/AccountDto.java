package com.aiquizgenerator.backend.account.dto;

public class AccountDto {
    private String username;

    public AccountDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
