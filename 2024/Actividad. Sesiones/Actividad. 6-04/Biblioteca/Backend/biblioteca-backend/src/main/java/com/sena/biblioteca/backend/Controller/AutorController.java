package com.sena.biblioteca.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.backend.Entity.Autor;
import com.sena.biblioteca.backend.IService.IAutorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/autor")
public class AutorController extends ABaseController<Autor, IAutorService>{

	protected AutorController(IAutorService service) {
		super(service, "Autor");
		// TODO Auto-generated constructor stub
	}
    
}