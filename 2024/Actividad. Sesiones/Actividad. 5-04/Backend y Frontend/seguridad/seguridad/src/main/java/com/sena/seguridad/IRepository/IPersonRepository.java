package com.sena.seguridad.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.Person;


@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{

}
