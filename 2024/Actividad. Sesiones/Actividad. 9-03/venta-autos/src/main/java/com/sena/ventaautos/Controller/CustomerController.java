package com.sena.ventaautos.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ventaautos.Entity.Customer;
import com.sena.ventaautos.IService.ICustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/customer")
public class CustomerController extends ABaseController<Customer,ICustomerService>{
    public CustomerController(ICustomerService service){
        super(service, "Customer");
    }

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
