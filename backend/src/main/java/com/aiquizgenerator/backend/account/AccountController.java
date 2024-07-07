package com.aiquizgenerator.backend.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiquizgenerator.backend.account.dto.AccountDto;
import com.aiquizgenerator.backend.account.dto.request.CreateAccountDto;
import com.aiquizgenerator.backend.account.services.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountDto createAccount(
            @RequestBody() CreateAccountDto createAccountDto) {
        return accountService.create(createAccountDto);
    }
}
