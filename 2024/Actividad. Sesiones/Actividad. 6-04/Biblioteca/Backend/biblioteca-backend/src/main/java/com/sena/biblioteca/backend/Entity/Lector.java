package com.sena.biblioteca.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lector")
public class Lector  extends ABaseEntity{

    @Column(name="codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name = "personalidad", length = 50, nullable = false)
	private String personaId;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

  
    
}
