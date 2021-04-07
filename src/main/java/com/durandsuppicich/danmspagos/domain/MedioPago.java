package com.durandsuppicich.danmspagos.domain;

public class MedioPago {

    protected Integer id;
	protected String observacion;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    @Override
    public String toString() {
        return "MedioPago [id=" + id + ", observacion=" + observacion + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((observacion == null) ? 0 : observacion.hashCode());
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
        MedioPago other = (MedioPago) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (observacion == null) {
            if (other.observacion != null)
                return false;
        } else if (!observacion.equals(other.observacion))
            return false;
        return true;
    }
}