package com.durandsuppicich.danmspagos.domain;

public class Transferencia extends MedioPago {

    private String cbuOrigen;
	private String cbuDestino;
	private Long codigo;
    
    public String getCbuOrigen() {
        return cbuOrigen;
    }
    public void setCbuOrigen(String cbuOrigen) {
        this.cbuOrigen = cbuOrigen;
    }
    public String getCbuDestino() {
        return cbuDestino;
    }
    public void setCbuDestino(String cbuDestino) {
        this.cbuDestino = cbuDestino;
    }
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return "Transferencia [cbuDestino=" + cbuDestino + ", cbuOrigen=" + cbuOrigen + ", codigo=" + codigo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Transferencia other = (Transferencia) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
}