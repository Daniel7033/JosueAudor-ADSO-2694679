package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Entity.City;
import com.sena.seguridad.IService.ICityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/city")
public class CityController extends ABaseController<City,ICityService>{
	public CityController(ICityService service) {
        super(service, "City");
    }

	

}
