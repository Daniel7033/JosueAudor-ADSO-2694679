package com.sena.ubicacion.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.ubicacion.Entity.Pais;

public interface IPaisRepository extends JpaRepository<Pais, Long> {

}
