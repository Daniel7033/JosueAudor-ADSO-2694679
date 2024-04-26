package com.sena.seguridad.DTO.Compañia;

import com.sena.seguridad.DTO.IGenericDto;

public interface ICompanyDto extends IGenericDto{

	String getNit();
	String getRs();
	String getAddres();
	String getCity_name();
	String getWeb();
	String getEmail();
	String getPhone();
}
