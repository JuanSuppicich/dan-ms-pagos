package com.durandsuppicich.danmspagos.dao;

import com.durandsuppicich.danmspagos.domain.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoJpaRepository extends JpaRepository<Pago, Integer> { }