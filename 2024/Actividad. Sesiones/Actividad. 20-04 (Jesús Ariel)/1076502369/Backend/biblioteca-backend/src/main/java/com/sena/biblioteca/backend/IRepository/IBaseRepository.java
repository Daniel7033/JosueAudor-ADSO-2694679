package com.sena.biblioteca.backend.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.biblioteca.backend.Entity.ABaseEntity;

public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long>{
    
}
