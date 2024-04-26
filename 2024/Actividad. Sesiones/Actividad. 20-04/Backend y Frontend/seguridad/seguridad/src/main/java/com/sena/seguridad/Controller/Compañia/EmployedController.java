package com.sena.seguridad.Controller.Compañia;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.IService.Compañia.IEmployedService;
import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.Entity.Employed;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/employed")
public class EmployedController extends ABaseController<Employed,IEmployedService>{

	protected EmployedController(IEmployedService service) {
		super(service, "Employed");
		// TODO Auto-generated constructor stub
	}


}
