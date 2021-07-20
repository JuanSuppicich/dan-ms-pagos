package com.durandsuppicich.danmspagos.repository;

import com.durandsuppicich.danmspagos.domain.PaymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentMethodJpaRepository extends JpaRepository<PaymentMethod, Integer> { }