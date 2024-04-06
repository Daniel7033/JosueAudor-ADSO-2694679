package com.sena.biblioteca.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.backend.Entity.Libro;
import com.sena.biblioteca.backend.IService.ILibroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/libro")
public class LibroController extends ABaseController<Libro, ILibroService>{

	protected LibroController(ILibroService service) {
		super(service, "Libro");
		// TODO Auto-generated constructor stub
	}
    
}