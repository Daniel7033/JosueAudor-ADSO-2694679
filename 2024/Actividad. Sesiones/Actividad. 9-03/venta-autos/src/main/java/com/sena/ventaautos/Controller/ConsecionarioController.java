package com.sena.ventaautos.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ventaautos.Entity.Consecionario;
import com.sena.ventaautos.IService.IConsecionarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/consecionario")
public class ConsecionarioController extends ABaseController<Consecionario,IConsecionarioService>{
    public ConsecionarioController(IConsecionarioService service){
        super(service, "Consecionario");
    }

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
