package com.durandsuppicich.danmspagos.domain;

import java.time.Instant;

public class Pago {
    
    private Integer id;
	private Cliente cliente;
	private Instant fecha;
	private MedioPago medio;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Instant getFecha() {
        return fecha;
    }
    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }
    public MedioPago getMedio() {
        return medio;
    }
    public void setMedio(MedioPago medio) {
        this.medio = medio;
    }

    @Override
    public String toString() {
        return "Pago [cliente=" + cliente + ", fecha=" + fecha + ", id=" + id + ", medio=" + medio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Pago other = (Pago) obj;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}