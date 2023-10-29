package com.workintech.mappings.dao;

import com.workintech.mappings.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
