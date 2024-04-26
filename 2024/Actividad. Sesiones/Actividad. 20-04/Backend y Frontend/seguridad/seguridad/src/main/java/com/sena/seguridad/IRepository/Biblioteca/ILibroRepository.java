package com.sena.seguridad.IRepository.Biblioteca;


import org.springframework.data.jpa.repository.Query;

import com.sena.seguridad.Entity.Libro;
import com.sena.seguridad.IRepository.IBaseRepository;

public interface ILibroRepository extends IBaseRepository<Libro, Long> {

    @Query(value = "SELECT COUNT(*) AS totalLibros FROM libro", nativeQuery = true)
    Integer getTotalLibrosDisponibles();
}
