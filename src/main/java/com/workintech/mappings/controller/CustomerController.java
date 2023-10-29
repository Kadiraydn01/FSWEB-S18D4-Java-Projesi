package com.workintech.mappings.controller;

import com.workintech.mappings.dto.CustomerResponse;
import com.workintech.mappings.entity.Customer;
import com.workintech.mappings.service.CustomerService;
import com.workintech.mappings.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    public CustomerResponse find(@PathVariable long id){
        return EntityConverter.findResult(customerService.find(id));
    }
    @PostMapping("/{id}")
    public CustomerResponse save(@RequestBody Customer customer, @PathVariable long id){
        return EntityConverter.findResult(customerService.save(customer));
    }
    @DeleteMapping("/{id}")
    public CustomerResponse remove(@PathVariable long id){
        return EntityConverter.findResult(customerService.delete(id));
    }
}
