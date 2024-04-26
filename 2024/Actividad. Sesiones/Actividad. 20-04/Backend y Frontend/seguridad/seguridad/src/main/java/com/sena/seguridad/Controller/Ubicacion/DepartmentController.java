package com.sena.seguridad.Controller.Ubicacion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.Entity.Department;
import com.sena.seguridad.IService.Ubicacion.IDepartmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/department")
public class DepartmentController extends ABaseController<Department,IDepartmentService>{
	public DepartmentController(IDepartmentService service) {
        super(service, "Department");
    }
	


}
