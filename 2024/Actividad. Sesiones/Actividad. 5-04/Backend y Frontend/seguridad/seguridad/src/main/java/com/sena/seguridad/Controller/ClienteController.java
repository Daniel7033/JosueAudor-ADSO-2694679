package com.sena.seguridad.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.Entity.Cliente;
import com.sena.seguridad.IService.IClienteService;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/cliente")
public class ClienteController extends ABaseController<Cliente, IClienteService>{

    protected ClienteController(IClienteService service) {
        super(service, "Cliente");
		// TODO Auto-generated constructor stub
    }
    
}
