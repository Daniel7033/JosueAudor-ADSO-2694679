package com.sena.seguridad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.IService.IEnumService;
import com.sena.seguridad.Service.EnumService;
import com.sena.seguridad.Utils.GeneroEnum;
import com.sena.seguridad.Utils.TipoDocumentoEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/enum")
public class EnumController {
    
    @GetMapping("/genero")
    public GeneroEnum[] GeneroEnum() {
        return service.getGenero();
    }
    
    @Autowired
    public IEnumService service;

    @GetMapping("/tipo_documento")
    public TipoDocumentoEnum[] TipoDocumentoEnum(){
        return service.getTipoDocumento();
    }

    }
    

