package com.durandsuppicich.danmspagos.dao;

import com.durandsuppicich.danmspagos.domain.Transferencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaJpaRepository extends JpaRepository<Transferencia, Integer> { }