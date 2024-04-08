package com.sena.seguridad.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Person;

@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long> {

    @Query(value = " SELECT  "
            + " id, "
            + " concat(first_name,'  ',last_name) as person "
            + "	FROM  "
            + "	person "
            + "	WHERE  "
            + " deleted_at IS NULL", nativeQuery = true)
    List<IPersonDto> getList();

    @Query(value = " SELECT  "
            + " id, "
            + " concat(first_name,'  ',last_name) as person "
            + "	FROM  "
            + "	person "
            + "	WHERE  "
            + " deleted_at IS NULL", nativeQuery = true)
    List<Object[]> getDList();

    @Query(value = "SELECT\r\n"
            + "    p.id,\r\n"
            + "    p.state,\r\n"
            + "    p.document,\r\n"
            + "    p.first_name AS firstName,\r\n"
            + "    p.last_name AS lastName\r\n"
            + "FROM\r\n"
            + "    person p\r\n"
            + "LEFT JOIN\r\n"
            + "    cliente c ON p.id = c.person_id\r\n"
            + "WHERE\r\n"
            + "    c.person_id IS NULL and type_document = :typeDocument ", nativeQuery = true)
    List<IPersonDto> getDocumentByType(@Param("typeDocument") String typeDocument);
  
}
