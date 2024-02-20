package com.sena.actividadrestaurante.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "restaurante")
public class Restaurante extends ABaseEntity{
    
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    
    @Column(name = "direccion", length = 50, nullable = false)
    private String direccion;
    
    @Column(name = "tipo_cocina", length = 50, nullable = false)
    private String tipoCocina;
    
    @Column(name = "menu", length = 1000, nullable = false)
    private String menu;
    
    @Column(name = "horario_atencion", length = 50, nullable = false)
    private Time horarioAtencion;
    
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

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

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Date getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(Date horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
}
