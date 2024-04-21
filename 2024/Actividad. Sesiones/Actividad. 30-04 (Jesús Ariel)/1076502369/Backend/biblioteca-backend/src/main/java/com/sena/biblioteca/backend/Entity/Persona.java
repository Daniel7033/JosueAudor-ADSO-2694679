package com.sena.biblioteca.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona extends ABaseEntity{

    @Column(name="nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;

	@Column(name = "telefono", length = 50, nullable = false)
	private String telefono;
    
    @Column(name = "email", length = 50, nullable = false)
	private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    }
