package com.durandsuppicich.danmspagos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cash", schema = "ms_accounting")
public class Cash extends PaymentMethod {

    @Column(name = "bill_number", unique = true, nullable = false)
    private Integer billNumber;

    public Cash() { }

    public Cash(String comment, Integer billNumber) {
        super(comment);
        this.billNumber = billNumber;
    }

    public Integer getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Integer billNumber) {
        this.billNumber = billNumber;
    }

    @Override
    public String toString() {
        return "Cash [billNumber=" + billNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((billNumber == null) ? 0 : billNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cash other = (Cash) obj;
        if (billNumber == null) {
            return other.billNumber == null;
        } else return billNumber.equals(other.billNumber);
    }
}