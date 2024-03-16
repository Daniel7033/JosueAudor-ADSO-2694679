package com.sena.JosueAudor.IRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.JosueAudor.Entity.Product;

@Repository
public interface IProductRespository extends JpaRepository<Product, Long>{
    
}
