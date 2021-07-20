package com.durandsuppicich.danmspagos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transfer", schema = "ms_accounting")
public class Transfer extends PaymentMethod {

    @Column(name = "cbu_origin", nullable = false, length = 22)
    private String cbuOrigin;

    @Column(name = "cbu_destination", nullable = false, length = 22)
	private String cbuDestination;

    @Column(unique = true, nullable = false)
	private Long code;

    public Transfer() { }

    public Transfer(String comment, String cbuOrigin, String cbuDestination, Long code) {
        super(comment);
        this.cbuOrigin = cbuOrigin;
        this.cbuDestination = cbuDestination;
        this.code = code;
    }

    public String getCbuOrigin() {
        return cbuOrigin;
    }

    public void setCbuOrigin(String cbuOrigin) {
        this.cbuOrigin = cbuOrigin;
    }

    public String getCbuDestination() {
        return cbuDestination;
    }

    public void setCbuDestination(String cbuDestination) {
        this.cbuDestination = cbuDestination;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Transfer [cbuDestination=" + cbuDestination + ", cbuOrigin=" + cbuOrigin + ", code=" + code + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
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
        Transfer other = (Transfer) obj;
        if (code == null) {
            return other.code == null;
        } else return code.equals(other.code);
    }
}