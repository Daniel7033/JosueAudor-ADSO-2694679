package com.sena.seguridad.DTO.Seguridad;

import com.sena.seguridad.DTO.IGenericDto;

public interface IViewDto extends IGenericDto  {
    
    String getModule();
    String getDescription();
   
    String getName();
    String getRoute();
    
 
}

