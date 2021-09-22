package com.durandsuppicich.danmspagos.repository;

import com.durandsuppicich.danmspagos.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerJpaRepository extends JpaRepository<Customer, Integer> { }