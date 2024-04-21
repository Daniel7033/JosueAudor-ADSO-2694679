package com.sena.biblioteca.backend.IService;

import java.util.List;

import com.sena.biblioteca.backend.DTO.RegistroDto;
import com.sena.biblioteca.backend.Entity.Registro;


public interface IRegistroService extends IBaseService<Registro>{
    
    List<RegistroDto> getCantidadLibros();
}

