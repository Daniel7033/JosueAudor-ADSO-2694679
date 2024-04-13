package com.sena.seguridad.DTO;

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
