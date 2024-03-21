package com.sena.ventaautos.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ventaautos.Entity.Employee;
import com.sena.ventaautos.IService.IEmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/employee")
public class EmployeeController extends ABaseController<Employee,IEmployeeService>{
    public EmployeeController(IEmployeeService service){
        super(service, "Employee");
    }

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
