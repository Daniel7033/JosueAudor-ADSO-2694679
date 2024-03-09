package com.sena.ventaautos.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ventaautos.Entity.Cars;
import com.sena.ventaautos.IService.ICarsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/cars")
public class CarsController extends ABaseController<Cars,ICarsService>{
    public CarsController(ICarsService service){
        super(service, "Cars");
    }

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
