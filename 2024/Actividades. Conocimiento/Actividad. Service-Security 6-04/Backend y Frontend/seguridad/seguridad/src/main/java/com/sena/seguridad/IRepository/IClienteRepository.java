package com.sena.seguridad.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.seguridad.DTO.IClienteDTO;
import com.sena.seguridad.Entity.Cliente;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente, Long> {

        @Query(value = "SELECT\r\n"
                        + "\r\n"
                        + "    \r\n"
                        + "    `person`.`document`,\r\n"
                        + "   \r\n"
                        + "    `person`.`type_document`\r\n"
                        + "   \r\n"
                        + "FROM `service_security`.`person`\r\n"
                        + "where id = :id", nativeQuery = true)

        String getDocument(@Param("id") Long id);

        @Query(value = "SELECT "
                        + "c.code AS code, p.first_name AS firstName, p.last_name AS lastName, p.document AS Document "
                        + "FROM cliente c INNER JOIN person p "
                        + "ON c.person_id = p.id "
                        + "WHERE c.code LIKE %:term% OR p.first_name LIKE %:term% OR p.last_name OR p.document LIKE %:term%", nativeQuery = true)
        List<IClienteDTO> searchClientData(@Param("term") String term);
}
