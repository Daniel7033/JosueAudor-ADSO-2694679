package com.sena.seguridad.IRepository.Ubicacion;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.Country;
import com.sena.seguridad.IRepository.IBaseRepository;
@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long> {


}
