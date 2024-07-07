package com.aiquizgenerator.backend.account.services;

import org.springframework.stereotype.Service;

import com.aiquizgenerator.backend.account.dto.AccountDto;
import com.aiquizgenerator.backend.account.dto.request.CreateAccountDto;
import com.aiquizgenerator.backend.account.entities.Account;
import com.aiquizgenerator.backend.account.factories.AccountFactory;
import com.aiquizgenerator.backend.account.repositories.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountFactory accountFactory;

    public AccountDto create(CreateAccountDto createAccountDto) {
        return toAccountDto(this.accountRepository.save(accountFactory.create(createAccountDto)));

    }

    public AccountDto toAccountDto(Account account) {
        return new AccountDto(account.getUsername());
    }
}
