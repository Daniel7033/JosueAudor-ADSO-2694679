package com.sena.biblioteca.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.backend.Entity.Bibliotecario;
import com.sena.biblioteca.backend.IService.IBibliotecarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/bibliotecario")
public class BibliotecarioController extends ABaseController<Bibliotecario, IBibliotecarioService>{

	protected BibliotecarioController(IBibliotecarioService service) {
		super(service, "Bibliotecario");
		// TODO Auto-generated constructor stub
	}
    
}