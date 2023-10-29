package com.workintech.mappings.dao;

import com.workintech.mappings.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
