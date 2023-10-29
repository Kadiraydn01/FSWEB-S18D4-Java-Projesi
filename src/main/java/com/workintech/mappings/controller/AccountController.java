package com.workintech.mappings.controller;

import com.workintech.mappings.dto.AccountResponse;
import com.workintech.mappings.dto.CustomerResponse;
import com.workintech.mappings.entity.Account;
import com.workintech.mappings.entity.Customer;
import com.workintech.mappings.service.AccountService;
import com.workintech.mappings.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;
    private CustomerService customerService;
    @Autowired

    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable long id){
        return accountService.findById(id);
    }
    @PostMapping("/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable long customerId){
        Customer customer = customerService.find(customerId);
        if (customer != null){
            customer.getAccountList().add(account);
            account.setCustomer(customer);
            accountService.save(account);
        }else {
            throw new RuntimeException("No Customer Found");
        }
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(), new CustomerResponse(customer.getId(), customer.getEmail(), customer.getFirstName()));
    }
    @DeleteMapping("/{id}")
    public AccountResponse remove (@PathVariable long id){
        Account account = accountService.findById(id);
        if (account != null){
            accountService.delete(id);
            return new AccountResponse(account.getId(), account.getAccountName(),
                    account.getMoneyAmount(),
                    new CustomerResponse(account.getCustomer().getId(),
                            account.getCustomer().getEmail(),
                            account.getCustomer().getLastName()));
        }else{
            throw new RuntimeException("No account found");
        }
    }
}
