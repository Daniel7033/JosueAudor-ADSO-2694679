package com.sena.seguridad.IRepository;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sena.seguridad.Entity.ABaseEntity;



@Repository
public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long>{

	
	

}
