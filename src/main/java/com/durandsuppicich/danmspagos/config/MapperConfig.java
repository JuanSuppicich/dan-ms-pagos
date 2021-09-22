package com.durandsuppicich.danmspagos.config;

import com.durandsuppicich.danmspagos.mapper.IPaymentMapper;
import com.durandsuppicich.danmspagos.mapper.PaymentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public IPaymentMapper paymentMapper() {
        return new PaymentMapper();
    }
}
