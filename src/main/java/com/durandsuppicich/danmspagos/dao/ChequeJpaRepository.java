package com.durandsuppicich.danmspagos.dao;

import com.durandsuppicich.danmspagos.domain.Cheque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChequeJpaRepository extends JpaRepository<Cheque, Integer> { }