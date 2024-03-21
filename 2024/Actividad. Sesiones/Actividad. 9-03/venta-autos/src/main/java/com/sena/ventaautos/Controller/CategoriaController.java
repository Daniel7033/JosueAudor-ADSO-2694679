package com.sena.ventaautos.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.ventaautos.Entity.Categoria;
import com.sena.ventaautos.IService.ICategoriaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/categoria")
public class CategoriaController extends ABaseController<Categoria,ICategoriaService>{
    public CategoriaController(ICategoriaService service){
        super(service, "Categoria");
    }

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
