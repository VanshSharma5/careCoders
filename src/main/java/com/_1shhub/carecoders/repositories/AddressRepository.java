package com._1shhub.carecoders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com._1shhub.carecoders.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}