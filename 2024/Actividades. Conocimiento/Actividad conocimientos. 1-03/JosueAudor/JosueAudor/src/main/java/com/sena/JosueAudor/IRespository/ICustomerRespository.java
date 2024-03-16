package com.sena.JosueAudor.IRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.JosueAudor.Entity.Customer;

@Repository
public interface ICustomerRespository extends JpaRepository<Customer, Long>{

    
}
