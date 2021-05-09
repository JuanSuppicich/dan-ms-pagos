package com.durandsuppicich.danmspagos.rest;

import java.util.List;
import java.util.Optional;

import com.durandsuppicich.danmspagos.domain.Pago;
import com.durandsuppicich.danmspagos.exception.NotFoundException;
import com.durandsuppicich.danmspagos.service.IServicioPago;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pago")
@Api(value = "PagoRest", description = "Permite gestionar los pagos")
public class PagoRest {

    private final IServicioPago servicioPago;

    public PagoRest(IServicioPago servicioPago) {
        this.servicioPago = servicioPago;
    }

    @PostMapping
    @ApiOperation(value = "Registra un nuevo pago")
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {

        Pago body = servicioPago.crear(pago);

        return ResponseEntity.ok(body);
    }

    @GetMapping
    @ApiOperation(value = "Lista todos los pagos")
    public ResponseEntity<List<Pago>> todos() {

        List<Pago> body = servicioPago.todos();

        return ResponseEntity.ok(body);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un pago por id")
    public ResponseEntity<Pago> pagoPorId(@PathVariable Integer id) {

        Optional<Pago> body = servicioPago.pagoPorId(id);
        
        if (body.isPresent()) {
            return ResponseEntity.ok(body.get());
        }
        else {
            throw new NotFoundException("Pago no encontrado. Id: " + id);
        }
    }
}