package com.durandsuppicich.danmspagos.domain;

public class Cliente {
    
    private Integer id;
    private String razonSocial;
    private String cuit;
    private String mail;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getCuit() {
        return cuit;
    }
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Cliente [cuit=" + cuit + ", id=" + id + ", mail=" + mail + ", razonSocial=" + razonSocial + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((mail == null) ? 0 : mail.hashCode());
        result = prime * result + ((razonSocial == null) ? 0 : razonSocial.hashCode());
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
        Cliente other = (Cliente) obj;
        if (cuit == null) {
            if (other.cuit != null)
                return false;
        } else if (!cuit.equals(other.cuit))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (mail == null) {
            if (other.mail != null)
                return false;
        } else if (!mail.equals(other.mail))
            return false;
        if (razonSocial == null) {
            if (other.razonSocial != null)
                return false;
        } else if (!razonSocial.equals(other.razonSocial))
            return false;
        return true;
    }
}