package com.sena.biblioteca.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro extends ABaseEntity{

    @Column(name="codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name = "titulo", length = 50, nullable = false)
	private String titulo;

	@Column(name = "ejemplares", length = 50, nullable = false)
	private Integer ejemplares;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", nullable = false, unique = true)
	private Autor autorId;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Autor getAutorId() {
		return autorId;
	}

	public void setAutorId(Autor autorId) {
		this.autorId = autorId;
	}
	
    	
	
	
	
}

    

