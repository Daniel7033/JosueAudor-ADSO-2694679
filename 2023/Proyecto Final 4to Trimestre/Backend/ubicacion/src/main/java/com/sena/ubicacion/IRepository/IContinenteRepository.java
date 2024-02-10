package com.sena.ubicacion.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.ubicacion.Entity.Continente;

public interface IContinenteRepository extends JpaRepository<Continente, Long> {

}
