package com.durandsuppicich.danmspagos.dao;

import com.durandsuppicich.danmspagos.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente, Integer> { }