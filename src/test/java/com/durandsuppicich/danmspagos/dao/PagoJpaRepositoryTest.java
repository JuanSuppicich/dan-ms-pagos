package com.durandsuppicich.danmspagos.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.durandsuppicich.danmspagos.domain.Cheque;
import com.durandsuppicich.danmspagos.domain.Cliente;
import com.durandsuppicich.danmspagos.domain.Efectivo;
import com.durandsuppicich.danmspagos.domain.MedioPago;
import com.durandsuppicich.danmspagos.domain.Pago;
import com.durandsuppicich.danmspagos.domain.Transferencia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Profile("testing")
public class PagoJpaRepositoryTest {

    @Autowired
    public PagoJpaRepository pagoRepository;

    @Test
    public void elRepositorioExiste() {
        assertNotNull(pagoRepository);
    }

    @Test
    @Sql(scripts = {"/datos_test.sql"})
    public void findAll_pagosAlmacenados_pagosRecuperadosConClienteYMedioPago() {

        List<Pago> pagos = pagoRepository.findAll();

        assertFalse(pagos.isEmpty());
        assertEquals(3, pagos.size());
    }

    @Test
    public void findById_pagoAlmacenado_pagoRecuperadoConClienteYMedioPago() {

        Optional<Pago> pago01 = pagoRepository.findById(1);
        Optional<Pago> pago02 = pagoRepository.findById(2);
        Optional<Pago> pago03 = pagoRepository.findById(3);

        assertTrue(pago01.isPresent());
        assertEquals(1, pago01.get().getId());
        assertNotNull(pago01.get().getCliente());
        assertEquals(1, pago01.get().getCliente().getId());
        assertTrue(pago01.get().getMedio() instanceof Efectivo);

        assertTrue(pago02.isPresent());
        assertEquals(2, pago02.get().getId());
        assertNotNull(pago01.get().getCliente());
        assertEquals(2, pago02.get().getCliente().getId());
        assertTrue(pago02.get().getMedio() instanceof Cheque);

        assertTrue(pago03.isPresent());
        assertEquals(3, pago03.get().getId());
        assertNotNull(pago01.get().getCliente());
        assertEquals(1, pago03.get().getCliente().getId());
        assertTrue(pago03.get().getMedio() instanceof Transferencia);
    }

    @Test
    public void save_pagoOk_pagoCreado() {

        Cliente cliente01 = new Cliente(1, "Cliente01", "11111111111", "cliente01@example.com");
        Cliente cliente02 = new Cliente(2, "Cliente02", "22222222222", "cliente02@example.com");

        MedioPago efectivo = new Efectivo("Observacion04", 2);

        MedioPago cheque = new Cheque("Observacion05", 2, Instant.now(), "Banco02");

        MedioPago transferencia = new Transferencia("Observacion06", "0202020202", "2020202020", 2L);

        Pago pago04 = new Pago(cliente01, Instant.now(), efectivo);
        Pago pago05 = new Pago(cliente01, Instant.now(), cheque);
        Pago pago06 = new Pago(cliente02, Instant.now(), transferencia);

        pagoRepository.save(pago04);
        pagoRepository.save(pago05);
        pagoRepository.save(pago06);

        assertEquals(6, pagoRepository.count());
    }
}