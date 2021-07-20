package com.durandsuppicich.danmspagos.repository;

import com.durandsuppicich.danmspagos.domain.Transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferJpaRepository extends JpaRepository<Transfer, Integer> { }