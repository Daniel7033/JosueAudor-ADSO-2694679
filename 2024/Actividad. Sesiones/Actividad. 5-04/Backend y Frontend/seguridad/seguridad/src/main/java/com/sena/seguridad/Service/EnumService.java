package com.sena.seguridad.Service;

import org.springframework.stereotype.Service;

import com.sena.seguridad.IService.IEnumService;
import com.sena.seguridad.Utils.GeneroEnum;
import com.sena.seguridad.Utils.MesEnum;
import com.sena.seguridad.Utils.NomenclaturaEnum;
import com.sena.seguridad.Utils.SemanaEnum;
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

    @Override
    public NomenclaturaEnum[] getNomenclatura() {
        return NomenclaturaEnum.values();
    }

    @Override
    public SemanaEnum[] getSemana() {
        return SemanaEnum.values();
    }

    @Override
    public MesEnum[] getMes() {
        return MesEnum.values();
    }

}
