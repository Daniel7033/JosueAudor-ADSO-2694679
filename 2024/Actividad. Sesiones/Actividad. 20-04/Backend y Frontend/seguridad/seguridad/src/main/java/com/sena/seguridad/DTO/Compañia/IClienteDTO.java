package com.sena.seguridad.DTO.Compañia;

import com.sena.seguridad.DTO.IGenericDto;

public interface IClienteDTO extends IGenericDto{

	String getCode();
    String getName();
    String getTypeDocument();
    String getDocument();
    String getPersonId();
    // String getList();
}
