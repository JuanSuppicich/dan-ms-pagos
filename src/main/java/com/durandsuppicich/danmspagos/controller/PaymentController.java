package com.durandsuppicich.danmspagos.controller;

import java.net.URI;
import java.util.List;

import com.durandsuppicich.danmspagos.domain.Payment;
import com.durandsuppicich.danmspagos.dto.PaymentDto;
import com.durandsuppicich.danmspagos.service.IPaymentService;

import com.durandsuppicich.danmspagos.mapper.IPaymentMapper;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Mod11Check;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/api/accounting")
@Api(value = "PaymentController")
@CrossOrigin(origins = "*", methods=
        {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PaymentController {

    private final IPaymentService paymentService;

    private final IPaymentMapper paymentMapper;

    public PaymentController(IPaymentService paymentService,
                             IPaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    @ApiOperation(value = "Creates a new payment")
    public ResponseEntity<PaymentDto> post(@RequestBody @Valid PaymentDto paymentDto) {

        Payment payment = paymentMapper.map(paymentDto);
        Payment result = paymentService.post(payment);
        PaymentDto body = paymentMapper.map(result);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(body.getId())
                .toUri();

        return ResponseEntity.created(location).body(body);
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all payments")
    public ResponseEntity<List<PaymentDto>> getAll() {

        List<Payment> result = paymentService.getAll();
        List<PaymentDto> body = paymentMapper.map(result);

        return ResponseEntity.ok(body);
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Retrieves a payment based on the given id")
    public ResponseEntity<PaymentDto> getById(@PathVariable @Positive Integer id) {

        Payment result = paymentService.getById(id);
        PaymentDto body = paymentMapper.map(result);

        return ResponseEntity.ok(body);
    }

    @GetMapping(params = "cuit")
    @ApiOperation(value = "Retrieves a payment based on the given customer's cuit")
    public ResponseEntity<List<PaymentDto>> getByCustomerCuit(@RequestParam(name = "cuit")
                                                               @NotBlank
                                                               @Length(min = 11, max = 11)
                                                               @Mod11Check(threshold = 7) String cuit) {
        
        List<Payment> result = paymentService.getByCustomerCuit(cuit);
        List<PaymentDto> body = paymentMapper.map(result);
        
        return ResponseEntity.ok(body);
    }
}