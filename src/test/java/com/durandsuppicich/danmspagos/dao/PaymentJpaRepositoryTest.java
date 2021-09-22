package com.durandsuppicich.danmspagos.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.durandsuppicich.danmspagos.domain.*;
import com.durandsuppicich.danmspagos.domain.Customer;

import com.durandsuppicich.danmspagos.repository.IPaymentJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Profile("testing")
public class PaymentJpaRepositoryTest {

    @Autowired
    public IPaymentJpaRepository pagoRepository;

    @Test
    public void elRepositorioExiste() {
        assertNotNull(pagoRepository);
    }

    @Test
    @Sql(scripts = {"/datos_test.sql"})
    public void findAll_pagosAlmacenados_pagosRecuperadosConClienteYMedioPago() {

        List<Payment> payments = pagoRepository.findAll();

        assertFalse(payments.isEmpty());
        assertEquals(3, payments.size());
    }

    @Test
    public void findById_pagoAlmacenado_pagoRecuperadoConClienteYMedioPago() {

        Optional<Payment> pago01 = pagoRepository.findById(1);
        Optional<Payment> pago02 = pagoRepository.findById(2);
        Optional<Payment> pago03 = pagoRepository.findById(3);

        assertTrue(pago01.isPresent());
        assertEquals(1, pago01.get().getId());
        assertNotNull(pago01.get().getCustomer());
        assertEquals(1, pago01.get().getCustomer().getId());
        assertTrue(pago01.get().getMethod() instanceof Cash);

        assertTrue(pago02.isPresent());
        assertEquals(2, pago02.get().getId());
        assertNotNull(pago01.get().getCustomer());
        assertEquals(2, pago02.get().getCustomer().getId());
        assertTrue(pago02.get().getMethod() instanceof Check);

        assertTrue(pago03.isPresent());
        assertEquals(3, pago03.get().getId());
        assertNotNull(pago01.get().getCustomer());
        assertEquals(1, pago03.get().getCustomer().getId());
        assertTrue(pago03.get().getMethod() instanceof Transfer);
    }

    @Test
    public void save_pagoOk_pagoCreado() {

        Customer customer01 = new Customer(1, "Cliente01", "11111111111", "customer01@example.com");
        Customer customer02 = new Customer(2, "Cliente02", "22222222222", "customer02@example.com");

        PaymentMethod efectivo = new Cash("Observacion04", 2);

        PaymentMethod cheque = new Check("Observacion05", 2, Instant.now(), "Banco02");

        PaymentMethod transferencia = new Transfer("Observacion06", "0202020202", "2020202020", 2L);

        Payment payment04 = new Payment(customer01, Instant.now(), efectivo);
        Payment payment05 = new Payment(customer01, Instant.now(), cheque);
        Payment payment06 = new Payment(customer02, Instant.now(), transferencia);

        pagoRepository.save(payment04);
        pagoRepository.save(payment05);
        pagoRepository.save(payment06);

        assertEquals(6, pagoRepository.count());
    }
}