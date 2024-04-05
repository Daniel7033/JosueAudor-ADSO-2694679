package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Entity.Country;
import com.sena.seguridad.IService.ICountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/country")
public class CountryController extends ABaseController<Country,ICountryService>{
	public CountryController(ICountryService service) {
        super(service, "Country");
    }

	
	
}
