package com.sena.seguridad.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IClienteDTO;
import com.sena.seguridad.DTO.IPersonDto;
import com.sena.seguridad.Entity.Cliente;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Long> {
        @Query(value = "SELECT "
                + "c.id, "
                + "c.code, "
                + "CONCAT(p.first_name, ' ', p.last_name) AS name, "
                + "p.type_document AS typeDocument, "
                + "p.document, "
                + "p.id AS personId, "
                + "c.state "
                + "FROM "
                + "cliente c "
                + "INNER JOIN person AS p ON p.id = c.person_id", nativeQuery = true)
        List<IClienteDTO> getList();

        @Query(value = " SELECT  "
                        + " type_document, "
                        + " document "
                        + "	FROM  "
                        + "	person "
                        + "	WHERE  "
                        + " id = :id", nativeQuery = true)
        IPersonDto getDocument(@Param("id") Long id);

        @Query(value = "SELECT * FROM cliente c WHERE c.person_id = : personId", nativeQuery = true)
        Cliente findByPersonId(@Param("personId") Long personId);
}
