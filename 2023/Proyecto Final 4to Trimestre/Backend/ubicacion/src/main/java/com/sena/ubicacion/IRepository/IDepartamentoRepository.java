package com.sena.ubicacion.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.ubicacion.Entity.Departamento;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {

}
