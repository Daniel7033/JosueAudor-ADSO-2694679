package com.sena.seguridad.Controller.Seguridad;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.Entity.Module;
import com.sena.seguridad.IService.Seguridad.IModuleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/module")
public class ModuleController extends ABaseController<Module,IModuleService>{
	public ModuleController(IModuleService service) {
        super(service, "Module");
    }
	
	
}
