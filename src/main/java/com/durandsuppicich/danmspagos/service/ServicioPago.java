package com.durandsuppicich.danmspagos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.durandsuppicich.danmspagos.domain.Pago;

import org.springframework.stereotype.Service;

@Service
public class ServicioPago implements IServicioPago {

    private List<Pago> pagos = new ArrayList<Pago>();
    private Integer ID_GEN = 1;

    @Override
    public Pago crear(Pago pago) {
        pago.setId(ID_GEN++);
        pagos.add(pago);
        return pago;
    }

    @Override
    public List<Pago> todos() {
        return pagos;
    }

    @Override
    public Optional<Pago> pagoPorId(Integer id) {
        Optional<Pago> optPago = pagos
            .stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
        return optPago;
    }

    @Override
    public void actualizar(Integer id, Pago pago) {
        OptionalInt indexOpt =   IntStream.range(0, pagos.size())
            .filter(i -> pagos.get(i).getId().equals(id))
            .findFirst();

        if (indexOpt.isPresent()) {
            pagos.set(indexOpt.getAsInt(), pago);
        }
        else {
            // Lanzar excepción
        }
    }

    @Override
    public void eliminar(Integer id) {
        OptionalInt indexOpt =   IntStream.range(0, pagos.size())
            .filter(i -> pagos.get(i).getId().equals(id))
            .findFirst();
        
        if (indexOpt.isPresent()) {
            pagos.remove(indexOpt.getAsInt());
        }
        else {
            // Lanzar excepción
        }
    }
}