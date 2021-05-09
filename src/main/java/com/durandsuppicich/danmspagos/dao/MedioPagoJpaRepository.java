package com.durandsuppicich.danmspagos.dao;

import com.durandsuppicich.danmspagos.domain.MedioPago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioPagoJpaRepository extends JpaRepository<MedioPago, Integer> { }