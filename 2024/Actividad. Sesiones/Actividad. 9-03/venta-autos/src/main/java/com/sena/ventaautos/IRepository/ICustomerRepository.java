package com.sena.ventaautos.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.ventaautos.Entity.Customer;

@Repository
public interface ICustomerRepository extends IBaseRepository<Customer, Long>{
    
}
