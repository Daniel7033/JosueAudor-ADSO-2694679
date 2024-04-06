package com.sena.biblioteca.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.backend.Entity.Registro;
import com.sena.biblioteca.backend.IService.IRegistroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/registro")
public class RegistroController extends ABaseController<Registro, IRegistroService>{

	protected RegistroController(IRegistroService service) {
		super(service, "Registro");
		// TODO Auto-generated constructor stub
	}
    
}