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

        @Query(value = " SELECT "
                        + " p.id, "
                        + " p.state, "
                        + " p.document, "
                        + " p.first_name AS firstName, "
                        + " p.last_name AS lastName "
                        + " FROM person p "
                        + " LEFT JOIN cliente c ON p.id = c.person_id "
                        + " WHERE "
                        + " c.person_id IS NULL and type_document = :typeDocument ", nativeQuery = true)
        List<IPersonDto> getDocumentByType(@Param("typeDocument") String typeDocument);

        @Query(value = " SELECT  "
                        + " type_document, "
                        + " document "
                        + "	FROM  "
                        + "	person "
                        + "	WHERE  "
                        + " id = :id", nativeQuery = true)
        IPersonDto getDocument(@Param("id") Long id);

}
