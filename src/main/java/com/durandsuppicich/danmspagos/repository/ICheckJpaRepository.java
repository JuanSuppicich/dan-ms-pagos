package com.durandsuppicich.danmspagos.repository;

import com.durandsuppicich.danmspagos.domain.Check;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheckJpaRepository extends JpaRepository<Check, Integer> { }