package com.sena.seguridad.IService.Biblioteca;

import com.sena.seguridad.Entity.Libro;
import com.sena.seguridad.IService.IBaseService;

public interface ILibroService extends IBaseService<Libro> {

    public Integer obtenerCantidadTotalDeLibros();

}
