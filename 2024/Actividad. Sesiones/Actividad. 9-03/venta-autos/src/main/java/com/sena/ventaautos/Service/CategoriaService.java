package com.sena.ventaautos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ventaautos.Entity.Categoria;
import com.sena.ventaautos.IRepository.IBaseRepository;
import com.sena.ventaautos.IRepository.ICategoriaRepository;
import com.sena.ventaautos.IService.ICategoriaService;

@Service
public class CategoriaService extends ABaseService<Categoria> implements ICategoriaService{

    @Override
    protected IBaseRepository<Categoria, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    private ICategoriaRepository repository;

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
