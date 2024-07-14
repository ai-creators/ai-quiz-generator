package com.aiquizgenerator.backend.account.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiquizgenerator.backend.account.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findBySub(String sub);
}
