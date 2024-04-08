package com.sena.seguridad.IService;

import com.sena.seguridad.Utils.GeneroEnum;
import com.sena.seguridad.Utils.MesEnum;
import com.sena.seguridad.Utils.NomenclaturaEnum;
import com.sena.seguridad.Utils.SemanaEnum;
import com.sena.seguridad.Utils.TipoDocumentoEnum;

public interface IEnumService{
    GeneroEnum[] getGenero();
    TipoDocumentoEnum[] getTipoDocumento();
    NomenclaturaEnum[] getNomenclatura();
    SemanaEnum[] getSemana();
    MesEnum[] getMes();
}

