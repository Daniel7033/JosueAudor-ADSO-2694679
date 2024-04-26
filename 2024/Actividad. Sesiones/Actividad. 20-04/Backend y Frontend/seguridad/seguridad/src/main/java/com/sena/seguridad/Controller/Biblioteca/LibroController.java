package com.sena.seguridad.Controller.Biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.Entity.Libro;
import com.sena.seguridad.IService.Biblioteca.ILibroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/libro")
public class LibroController extends ABaseController<Libro, ILibroService> {

	protected LibroController(ILibroService service) {
		super(service, "Libro");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/cantidad")
	public Integer cantidad() {
		return service.obtenerCantidadTotalDeLibros();
	}

}