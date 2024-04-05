package com.sena.seguridad.Service;

import org.springframework.stereotype.Service;

import com.sena.seguridad.IService.IEnumService;
import com.sena.seguridad.Utils.GeneroEnum;
import com.sena.seguridad.Utils.TipoDocumentoEnum;

@Service
public class EnumService implements IEnumService{
    
    @Override
    public GeneroEnum[] getGenero(){
        return GeneroEnum.values();
    }

    @Override
    public TipoDocumentoEnum[] getTipoDocumento(){
        return TipoDocumentoEnum.values();
    }

}
