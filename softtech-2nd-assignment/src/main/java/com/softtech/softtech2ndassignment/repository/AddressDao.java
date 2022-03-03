package com.softtech.softtech2ndassignment.repository;

import com.softtech.softtech2ndassignment.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {
}
