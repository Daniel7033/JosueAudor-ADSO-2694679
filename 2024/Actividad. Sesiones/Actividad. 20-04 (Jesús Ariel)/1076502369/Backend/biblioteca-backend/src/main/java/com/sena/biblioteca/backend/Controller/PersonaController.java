package com.sena.biblioteca.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.backend.Entity.Persona;
import com.sena.biblioteca.backend.IService.IPersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/persona")
public class PersonaController extends ABaseController<Persona, IPersonaService>{

	protected PersonaController(IPersonaService service) {
		super(service, "Persona");
		// TODO Auto-generated constructor stub
	}
    
}