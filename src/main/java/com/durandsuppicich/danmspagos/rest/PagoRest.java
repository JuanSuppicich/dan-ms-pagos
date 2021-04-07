package com.durandsuppicich.danmspagos.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import com.durandsuppicich.danmspagos.domain.Pago;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pago")
@Api(value = "PagoRest", description =  "Permite gestionar los pagos")
public class PagoRest {
    
    private List<Pago> pagos = new ArrayList<Pago>();
    private Integer ID_GEN = 1;

    @PostMapping
    @ApiOperation(value = "Registra un nuevo pago")
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {
        pago.setId(ID_GEN++);
        pagos.add(pago);
        return ResponseEntity.ok(pago);
    }

    @GetMapping
    @ApiOperation(value = "Lista todos los pagos")
    public ResponseEntity<List<Pago>> todos() {
        return ResponseEntity.ok(pagos);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Busca un pago por id")
    public ResponseEntity<Pago> pagoPorId(@PathVariable Integer id) {
        Optional<Pago> pago = pagos
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return ResponseEntity.of(pago);
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Actualiza un pago en base al id")
    public ResponseEntity<Pago> actualizar(@RequestBody Pago pago,  @PathVariable Integer id) {
        OptionalInt indexOpt =   IntStream.range(0, pagos.size())
        .filter(i -> pagos.get(i).getId().equals(id))
        .findFirst();

        if (indexOpt.isPresent()) {
            pagos.set(indexOpt.getAsInt(), pago);
            return ResponseEntity.ok(pago);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Elimina un pago en base al id")
    public ResponseEntity<Pago> eliminar(@PathVariable Integer id) {
        OptionalInt indexOpt =   IntStream.range(0, pagos.size())
        .filter(i -> pagos.get(i).getId().equals(id))
        .findFirst();

        if (indexOpt.isPresent()) {
            pagos.remove(indexOpt.getAsInt());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}