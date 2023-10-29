package com.workintech.mappings.service;

import com.workintech.mappings.dao.AccountRepository;
import com.workintech.mappings.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
@Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        return accountOptional.orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(long id) {
    Account account = findById(id);
    if (account != null){
        accountRepository.delete(account);
        return account;
    }
        return null;
    }
}
