package com.aiquizgenerator.backend.account.services;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

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
        return toAccountDto(accountRepository.save(accountFactory.create(createAccountDto)));

    }

    public Account findBySub(String sub) throws AccountNotFoundException {
        Account account = accountRepository.findBySub(sub).orElseThrow(() -> new AccountNotFoundException("Account not found"));

        System.out.println(account);

        return account;
    }

    public AccountDto toAccountDto(Account account) {
        return new AccountDto(account.getUsername());
    }
}
