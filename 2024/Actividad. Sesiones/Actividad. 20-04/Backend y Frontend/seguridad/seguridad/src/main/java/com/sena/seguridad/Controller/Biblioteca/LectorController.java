package com.sena.seguridad.Controller.Biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.Entity.Lector;
import com.sena.seguridad.IService.Biblioteca.ILectorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/lector")
public class LectorController extends ABaseController<Lector, ILectorService>{

	protected LectorController(ILectorService service) {
		super(service, "Lector");
		// TODO Auto-generated constructor stub
	}
    
}