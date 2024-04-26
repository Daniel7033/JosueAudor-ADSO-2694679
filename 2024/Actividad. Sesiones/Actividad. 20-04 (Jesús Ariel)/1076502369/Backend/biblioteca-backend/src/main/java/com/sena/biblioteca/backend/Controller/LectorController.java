package com.sena.biblioteca.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.biblioteca.backend.Entity.Lector;
import com.sena.biblioteca.backend.IService.ILectorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/lector")
public class LectorController extends ABaseController<Lector, ILectorService>{

	protected LectorController(ILectorService service) {
		super(service, "Lector");
		// TODO Auto-generated constructor stub
	}
    
}