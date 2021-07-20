package com.durandsuppicich.danmspagos.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "check", schema = "ms_accounting")
public class Check extends PaymentMethod {

    @Column(unique = true, nullable = false)
    private Integer number;

    @Column(name = "payment_date")
	private Instant paymentDate;

    @Column(nullable = false, length = 32)
	private String bank;

    public Check() { }

    public Check(String comment, Integer number, Instant paymentDate, String bank) {
        super(comment);
        this.number = number;
        this.paymentDate = paymentDate;
        this.bank = bank;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Check [bank=" + bank + ", paymentDate=" + paymentDate + ", number=" + number + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bank == null) ? 0 : bank.hashCode());
        result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Check other = (Check) obj;
        if (bank == null) {
            if (other.bank != null)
                return false;
        } else if (!bank.equals(other.bank))
            return false;
        if (paymentDate == null) {
            if (other.paymentDate != null)
                return false;
        } else if (!paymentDate.equals(other.paymentDate))
            return false;
        if (number == null) {
            return other.number == null;
        } else return number.equals(other.number);
    }
}