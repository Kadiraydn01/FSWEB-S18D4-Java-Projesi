package com.workintech.mappings.service;

import com.workintech.mappings.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(long id);
    Account save(Account account);
    Account delete(long id);
}
