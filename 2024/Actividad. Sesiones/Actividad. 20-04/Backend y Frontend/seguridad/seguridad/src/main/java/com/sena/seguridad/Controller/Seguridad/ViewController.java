package com.sena.seguridad.Controller.Seguridad;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Controller.ABaseController;
import com.sena.seguridad.Entity.View;
import com.sena.seguridad.IService.Seguridad.IViewService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/view")
public class ViewController extends ABaseController<View,IViewService>{
	public ViewController(IViewService service) {
        super(service, "View");
    }
	
	
}
