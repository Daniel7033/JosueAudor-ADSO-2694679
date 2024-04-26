package com.sena.seguridad.IRepository.Compañia;

import org.springframework.stereotype.Repository;


import com.sena.seguridad.Entity.Company;
import com.sena.seguridad.IRepository.IBaseRepository;

@Repository
public interface ICompanyRepository extends IBaseRepository<Company, Long>{

}
