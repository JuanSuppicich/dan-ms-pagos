package com.durandsuppicich.danmspagos.repository;

import java.util.List;

import com.durandsuppicich.danmspagos.domain.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentJpaRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByCustomerCuit(String cuit);
}