package com.sena.ventaautos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Cars extends ABaseEntity{
    
    @Column(name = "model", length = 50, nullable = false)
    private String model;
    
    @Column(name = "description", length = 50, nullable = false)
    private String description;
    
    @Column(name = "matricula", length = 50, nullable = false)
    private String matricula;
    
    @Column(name = "color", length = 20, nullable = false)
    private String color;
    
    @Column(name = "costo", nullable = false)
    private Double costo;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "consecionario_id", nullable = false, unique = true)
    public Consecionario consecionarioId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employee_id", nullable = false, unique = true)
    public Employee employeeId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, unique = true)
    public Customer customerId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoria_id", nullable = false, unique = true)
    public Categoria categoriaId;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Consecionario getConsecionarioId() {
        return consecionarioId;
    }

    public void setConsecionarioId(Consecionario consecionarioId) {
        this.consecionarioId = consecionarioId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

}
