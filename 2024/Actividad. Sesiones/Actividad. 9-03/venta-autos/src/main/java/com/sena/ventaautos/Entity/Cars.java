package com.sena.ventaautos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Cars extends ABaseEntity{
    
    @Column(name = "model", length = 50, nullable = false)
    private String model;
    
    @Column(name = "matricula", length = 50, nullable = false)
    private String matricula;
    
    @Column(name = "color", length = 20, nullable = false)
    private String color;
    
    @Column(name = "costo", nullable = false)
    private Double costo;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    
}
