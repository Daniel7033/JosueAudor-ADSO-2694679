package com.sena.ventaautos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ventaautos.Entity.Seller;
import com.sena.ventaautos.IRepository.IBaseRepository;
import com.sena.ventaautos.IRepository.ISellerRepository;
import com.sena.ventaautos.IService.ISellerService;

@Service
public class SellerService extends ABaseService<Seller> implements ISellerService{

    @Override
    protected IBaseRepository<Seller, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    private ISellerRepository repository;

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
