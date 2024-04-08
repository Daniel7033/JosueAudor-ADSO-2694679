package com.sena.seguridad.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.Country;
@Repository
public interface ICountryRepository extends IBaseRepository<Country, Long> {


}
