package com.sena.ventaautos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ventaautos.Entity.Customer;
import com.sena.ventaautos.IRepository.IBaseRepository;
import com.sena.ventaautos.IRepository.ICustomerRepository;
import com.sena.ventaautos.IService.ICustomerService;

@Service
public class CustomerService extends ABaseService<Customer> implements ICustomerService{

    @Override
    protected IBaseRepository<Customer, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    private ICustomerRepository repository;

    // Aquí colocar los DTO en caso de su uso y requerimiento
    // ...
}
