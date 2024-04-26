package com.sena.seguridad.DTO.Compañia;

import com.sena.seguridad.DTO.IGenericDto;

public interface IContractDto extends IGenericDto{
	String getCode();
	String getDate_start();
	String getDate_ending();
	String getSalary();
	String getObject();
	String getCompany();
	String getPerson();
}
