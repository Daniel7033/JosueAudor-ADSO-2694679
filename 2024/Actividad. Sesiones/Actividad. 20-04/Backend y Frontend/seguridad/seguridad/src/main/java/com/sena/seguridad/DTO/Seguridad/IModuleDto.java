package com.sena.seguridad.DTO.Seguridad;

import java.util.List;

import com.sena.seguridad.DTO.IGenericDto;

public interface IModuleDto extends IGenericDto{


    String getModule();
    String getDescription();
 
    Long getId();
    Boolean getState();
    
    String getViewName();
    String getViewRoute();
    List<IViewDto> getViews();
    void setViews(List<IViewDto> views);
}
