package com.sena.seguridad.IService;

import com.sena.seguridad.Utils.GeneroEnum;
import com.sena.seguridad.Utils.TipoDocumentoEnum;

public interface IEnumService{
    GeneroEnum[] getGenero();
    TipoDocumentoEnum[] getTipoDocumento();
}
