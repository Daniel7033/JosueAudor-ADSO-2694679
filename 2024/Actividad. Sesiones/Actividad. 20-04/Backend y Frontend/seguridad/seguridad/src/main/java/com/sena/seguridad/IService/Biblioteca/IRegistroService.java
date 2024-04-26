package com.sena.seguridad.IService.Biblioteca;

import java.util.List;

import com.sena.seguridad.DTO.Biblioteca.RegistroDto;
import com.sena.seguridad.Entity.Registro;
import com.sena.seguridad.IService.IBaseService;


public interface IRegistroService extends IBaseService<Registro>{
    
    List<RegistroDto> getCantidadLibros();
}

