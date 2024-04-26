package com.sena.seguridad.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.seguridad.IService.IEnumService;
import com.sena.seguridad.Utils.GeneroEnum;
import com.sena.seguridad.Utils.TipoDocumentoEnum;
import com.sena.seguridad.Utils.*;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/api/enum")
public class EnumController {

    @Autowired
    public IEnumService service;

    @GetMapping("/genero")
    public GeneroEnum[] GeneroEnum() {
        return service.getGenero();
    }

    @GetMapping("/tipo_documento")
    public TipoDocumentoEnum[] TipoDocumentoEnum() {
        return service.getTipoDocumento();
    }

    @GetMapping("/nomenclatura")
    public NomenclaturaEnum[] NomenclaturaEnum(){
        return service.getNomenclatura();
    }

    @GetMapping("/semana")
    public SemanaEnum[] SemanaEnum(){
        return service.getSemana();
    }

    @GetMapping("/meses")
    public MesEnum[] MesEnum(){
        return service.getMes();
    }

}
