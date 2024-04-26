package com.sena.seguridad.DTO.Seguridad;

import com.sena.seguridad.DTO.IGenericDto;

public interface IPersonDto extends IGenericDto{

	String getTypeDocument();
    void setTypeDocument(String typeDocument);
    String getCode();
    String getDocument();
	String getFirstName();
	String getLastName();
	String getPersonId();
	String getPerson();
}
