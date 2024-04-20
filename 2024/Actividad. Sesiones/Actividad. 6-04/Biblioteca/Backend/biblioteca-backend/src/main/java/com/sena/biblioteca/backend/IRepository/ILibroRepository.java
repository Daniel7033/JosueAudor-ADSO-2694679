package com.sena.biblioteca.backend.IRepository;


import org.springframework.data.jpa.repository.Query;

import com.sena.biblioteca.backend.Entity.Libro;

public interface ILibroRepository extends IBaseRepository<Libro, Long> {

    @Query(value = "SELECT COUNT(*) AS totalLibros FROM libro", nativeQuery = true)
    Integer getTotalLibrosDisponibles();
}
