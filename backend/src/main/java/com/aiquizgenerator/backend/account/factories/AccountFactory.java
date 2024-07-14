package com.aiquizgenerator.backend.account.factories;

import org.springframework.stereotype.Component;

import com.aiquizgenerator.backend.account.dto.request.CreateAccountDto;
import com.aiquizgenerator.backend.account.entities.Account;

@Component
public class AccountFactory {
    public Account create(CreateAccountDto createAccountDto) {
        
        Account account = new Account(
                createAccountDto.getSub(),
                createAccountDto.getUsername());

        return account;
    }
}
