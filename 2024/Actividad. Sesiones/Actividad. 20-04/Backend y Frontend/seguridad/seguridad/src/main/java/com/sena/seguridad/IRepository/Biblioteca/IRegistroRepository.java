package com.sena.seguridad.IRepository.Biblioteca;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sena.seguridad.DTO.Biblioteca.RegistroDto;
import com.sena.seguridad.Entity.Registro;
import com.sena.seguridad.IRepository.IBaseRepository;

public interface IRegistroRepository extends IBaseRepository<Registro, Long> {
    
    @Query(value = "SELECT persona.nombre, count(libro.id) AS total "
                +   "FROM registro "
                +   "INNER JOIN lector ON lector.id = registro.lector_id "
                +   "JOIN persona, libro WHERE lector.persona_id = persona.id AND libro.id = registro.libro_id "
                +   "GROUP BY persona.nombre;", nativeQuery = true)
    List<RegistroDto> getCantidadLibros();
}
