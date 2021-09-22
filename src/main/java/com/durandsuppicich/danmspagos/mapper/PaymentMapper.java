package com.durandsuppicich.danmspagos.mapper;

import com.durandsuppicich.danmspagos.domain.*;
import com.durandsuppicich.danmspagos.dto.*;

import java.util.ArrayList;
import java.util.List;

public class PaymentMapper implements IPaymentMapper {

    @Override
    public Payment map(PaymentDto paymentDto) {

        Payment payment = new Payment();
        Customer customer = new Customer();

        customer.setId(paymentDto.getCustomerId());
        payment.setDate(paymentDto.getDate());
        payment.setCustomer(customer);

        if (paymentDto.getMethod() instanceof CashDto) {
            payment.setMethod(mapToCash(paymentDto.getMethod()));
        }
        else {
            if (paymentDto.getMethod() instanceof CheckDto) {
                payment.setMethod(mapToCheck(paymentDto.getMethod()));
            }
            else {
                payment.setMethod(mapToTransfer(paymentDto.getMethod()));
            }
        }
        return payment;
    }

    @Override
    public PaymentDto map(Payment payment) {

        PaymentDto paymentDto = new PaymentDto();
        PaymentMethodDto paymentMethodDto= new PaymentMethodDto();

        paymentDto.setId(payment.getId());
        paymentDto.setCustomerId(payment.getCustomer().getId());
        paymentDto.setDate(payment.getDate());

        if (payment.getMethod() instanceof Cash) {
            paymentDto.setMethod(mapToCashDto(payment.getMethod()));
        }
        else {
            if (payment.getMethod() instanceof Check) {
                paymentDto.setMethod(mapToCheckDto(payment.getMethod()));
            }
            else {
                paymentDto.setMethod(mapToTransferDto(payment.getMethod()));
            }
        }
        return paymentDto;
    }

    @Override
    public List<PaymentDto> map(List<Payment> payments) {

        List<PaymentDto> paymentDtos = new ArrayList<>();

        for(Payment payment : payments) {

            PaymentDto paymentDto = map(payment);
            paymentDtos.add(paymentDto);
        }
        return paymentDtos;
    }

    private Cash mapToCash(PaymentMethodDto paymentMethodDto) {
        CashDto cashDto = (CashDto) paymentMethodDto;
        return new Cash(cashDto.getComment(), cashDto.getBillNumber());
    }

    private Check mapToCheck(PaymentMethodDto paymentMethodDto) {
        CheckDto checkDto = (CheckDto) paymentMethodDto;
        return new Check(
                checkDto.getComment(),
                checkDto.getNumber(),
                checkDto.getPaymentDate(),
                checkDto.getBank()
        );
    }

    private Transfer mapToTransfer(PaymentMethodDto paymentMethodDto) {
        TransferDto transferDto = (TransferDto) paymentMethodDto;
        return new Transfer(
                transferDto.getComment(),
                transferDto.getCbuOrigin(),
                transferDto.getCbuDestination(),
                transferDto.getCode()
        );
    }

    private CashDto mapToCashDto(PaymentMethod paymentMethod) {
        Cash cash = (Cash) paymentMethod;
        return new CashDto(
                cash.getComment(),
                cash.getBillNumber()
        );
    }

    private CheckDto mapToCheckDto(PaymentMethod paymentMethod) {
        Check check = (Check) paymentMethod;
        return new CheckDto(
                check.getComment(),
                check.getNumber(),
                check.getPaymentDate(),
                check.getBank()
        );
    }

    private TransferDto mapToTransferDto(PaymentMethod paymentMethod) {
        Transfer transfer = (Transfer) paymentMethod;
        return new TransferDto(
                transfer.getComment(),
                transfer.getCbuOrigin(),
                transfer.getCbuDestination(),
                transfer.getCode()
        );
    }

}
