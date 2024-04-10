package com.sena.seguridad.DTO;

public interface IClienteDTO extends IGenericDto{

	String getCode();
    void setCode(String code);
	Long getId();
    void setId(Long id);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
}
