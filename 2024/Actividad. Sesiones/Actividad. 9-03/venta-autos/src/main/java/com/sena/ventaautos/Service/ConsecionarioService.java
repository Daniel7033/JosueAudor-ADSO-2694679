package com.sena.ventaautos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ventaautos.Entity.Consecionario;
import com.sena.ventaautos.IRepository.IBaseRepository;
import com.sena.ventaautos.IRepository.IConsecionarioRepository;
import com.sena.ventaautos.IService.IConsecionarioService;

@Service
public class ConsecionarioService extends ABaseService<Consecionario> implements IConsecionarioService{

    @Override
    protected IBaseRepository<Consecionario, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    private IConsecionarioRepository repository;

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
