package com.durandsuppicich.danmspagos.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CHEQUE")
public class Cheque extends MedioPago {

    @Column(unique = true, nullable = false)
    private Integer numero;

    @Column(nullable = false)
	private Instant fechaCobro;

    @Column(nullable = false, length = 32)
	private String banco;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Instant getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Instant fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Cheque [banco=" + banco + ", fechaCobro=" + fechaCobro + ", numero=" + numero + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((banco == null) ? 0 : banco.hashCode());
        result = prime * result + ((fechaCobro == null) ? 0 : fechaCobro.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        Cheque other = (Cheque) obj;
        if (banco == null) {
            if (other.banco != null)
                return false;
        } else if (!banco.equals(other.banco))
            return false;
        if (fechaCobro == null) {
            if (other.fechaCobro != null)
                return false;
        } else if (!fechaCobro.equals(other.fechaCobro))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
}