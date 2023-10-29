package com.workintech.mappings.controller;

import com.workintech.mappings.entity.Address;
import com.workintech.mappings.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;
    @Autowired

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> findAll(){
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public Address find(@PathVariable long id){
        return addressService.find(id);
    }
    @PostMapping("/{id}")
    public Address save(@RequestBody Address address ,@PathVariable long id){
        return addressService.save(address);
    }
    @DeleteMapping("/{id}")
    public Address remove(@PathVariable long id){
        return addressService.delete(id);
    }
}
