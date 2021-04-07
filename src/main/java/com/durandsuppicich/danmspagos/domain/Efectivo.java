package com.durandsuppicich.danmspagos.domain;

public class Efectivo extends MedioPago {
    
    private Integer nroRecibo;

    public Integer getNroRecibo() {
        return nroRecibo;
    }

    public void setNroRecibo(Integer nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    @Override
    public String toString() {
        return "Efectivo [nroRecibo=" + nroRecibo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((nroRecibo == null) ? 0 : nroRecibo.hashCode());
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
        Efectivo other = (Efectivo) obj;
        if (nroRecibo == null) {
            if (other.nroRecibo != null)
                return false;
        } else if (!nroRecibo.equals(other.nroRecibo))
            return false;
        return true;
    }
}