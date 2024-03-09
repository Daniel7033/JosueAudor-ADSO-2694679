package com.sena.ventaautos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ventaautos.Entity.Cars;
import com.sena.ventaautos.IRepository.IBaseRepository;
import com.sena.ventaautos.IRepository.ICarsRepository;
import com.sena.ventaautos.IService.ICarsService;

@Service
public class CarsService extends ABaseService<Cars> implements ICarsService{

    @Override
    protected IBaseRepository<Cars, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    private ICarsRepository repository;

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
