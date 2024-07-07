package com.aiquizgenerator.backend.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiquizgenerator.backend.account.dto.request.CreateAccountDto;
import com.aiquizgenerator.backend.account.services.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public String createAccount(
            @RequestBody() CreateAccountDto createAccountDto) {
        return createAccountDto.getSub() + createAccountDto.getUsername();
    }
}
