package com.aiquizgenerator.backend.account.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aiquizgenerator.backend.account.entities.Account;

public interface AccountRepository extends CrudRepository<Account, String> {
}
