package com.workintech.mappings.service;

import com.workintech.mappings.dao.AddressRepository;
import com.workintech.mappings.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService{
    private AddressRepository addressRepository;
@Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address find(long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElse(null);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address) ;
    }

    @Override
    public Address delete(long id) {
        Address address = find(id);
        if (address != null) {
            addressRepository.delete(address);
            return address;
        }
        return null;
    }
}
