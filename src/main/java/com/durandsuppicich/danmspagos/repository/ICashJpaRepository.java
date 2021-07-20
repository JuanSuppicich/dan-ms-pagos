package com.durandsuppicich.danmspagos.repository;

import com.durandsuppicich.danmspagos.domain.Cash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICashJpaRepository extends JpaRepository<Cash, Integer> { }