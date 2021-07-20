package com.durandsuppicich.danmspagos.service;

import java.util.List;

import com.durandsuppicich.danmspagos.exception.payment.PaymentIdNotFoundException;
import com.durandsuppicich.danmspagos.repository.IPaymentJpaRepository;
import com.durandsuppicich.danmspagos.domain.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    private final IPaymentJpaRepository paymentRepository;

    public PaymentService(IPaymentJpaRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment post(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentIdNotFoundException(id));
    }

    @Override
    public List<Payment> getByCustomerCuit(String cuit) {
        return paymentRepository.findByCustomerCuit(cuit);
    }

}