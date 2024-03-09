package com.sena.ventaautos.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.ventaautos.Entity.Cars;

@Repository
public interface ICarsRepository extends IBaseRepository<Cars, Long>{
    
}
