package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.IService.ICompanyService;
import com.sena.seguridad.Entity.Company;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/company")
public class CompanyController extends ABaseController<Company,ICompanyService>{

	protected CompanyController(ICompanyService service) {
		super(service, "Company");
		// TODO Auto-generated constructor stub
	}

}
