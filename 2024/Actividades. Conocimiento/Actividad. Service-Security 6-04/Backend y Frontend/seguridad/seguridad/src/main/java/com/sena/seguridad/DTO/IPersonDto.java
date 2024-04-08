package com.sena.seguridad.DTO;

public interface IPersonDto extends IGenericDto{

	String getType_document();
    void setType_document(String type_document);
    String getCode();
    void setCode(String code);
    String getDocument();
	String getFirstName();
	String getLastName();
	String getPerson();
}
