package com.sena.servicesecurity.IRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Person;

@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{
    @Query(value = "SELECT" 
    + "id, "
    + "CONCAT(first_name, ' ', last_name) as 'Nombre completo'"
    + "FROM " 
    + "person", nativeQuery = true)
    List<IPersonDto> getListPerson();
}
