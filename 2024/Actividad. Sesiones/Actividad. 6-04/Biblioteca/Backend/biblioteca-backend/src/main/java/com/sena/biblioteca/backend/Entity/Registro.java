package com.sena.biblioteca.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro")
public class Registro extends ABaseEntity{

    @Column(name="fecha_inicio", length = 50, nullable = false)
	private String fechaInicio;
	
	@Column(name = "fecha_fin", length = 50, nullable = false)
	private String fechaFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lector_id", nullable = false, unique = true)
    private Lector lectorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "libro_id", nullable = false, unique = true)
    private Libro libroId;

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Lector getLectorId() {
        return lectorId;
    }

    public void setLectorId(Lector lectorId) {
        this.lectorId = lectorId;
    }

    public Libro getLibroId() {
        return libroId;
    }

    public void setLibroId(Libro libroId) {
        this.libroId = libroId;
    }

    
}
