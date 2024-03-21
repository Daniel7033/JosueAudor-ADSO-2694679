package com.sena.ventaautos.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria extends ABaseEntity{
    
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
