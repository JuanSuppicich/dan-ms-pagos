package com.durandsuppicich.danmspagos.dao;

import com.durandsuppicich.danmspagos.domain.Efectivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfectivoJpaRepository extends JpaRepository<Efectivo, Integer> { }