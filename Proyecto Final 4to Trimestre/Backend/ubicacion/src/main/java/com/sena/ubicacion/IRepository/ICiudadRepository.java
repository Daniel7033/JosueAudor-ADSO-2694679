package com.sena.ubicacion.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.ubicacion.Entity.Ciudad;

public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {

}