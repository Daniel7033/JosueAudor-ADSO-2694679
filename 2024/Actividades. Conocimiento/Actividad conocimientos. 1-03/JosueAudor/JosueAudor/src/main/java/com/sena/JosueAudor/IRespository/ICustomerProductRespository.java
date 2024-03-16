package com.sena.JosueAudor.IRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.JosueAudor.Entity.CustomerProduct;

@Repository
public interface ICustomerProductRespository extends JpaRepository<CustomerProduct, Long>{
    
}
