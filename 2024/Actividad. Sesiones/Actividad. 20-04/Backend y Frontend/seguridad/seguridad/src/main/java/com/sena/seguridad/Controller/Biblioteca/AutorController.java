package com.sena.seguridad.Controller.Biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.Entity.Autor;
import com.sena.seguridad.IService.Biblioteca.IAutorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/autor")
public class AutorController extends ABaseController<Autor, IAutorService>{

	protected AutorController(IAutorService service) {
		super(service, "Autor");
		// TODO Auto-generated constructor stub
	}
    
}