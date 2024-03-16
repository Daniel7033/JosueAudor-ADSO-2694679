package com.sena.JosueAudor.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.JosueAudor.Entity.CustomerProduct;
import com.sena.JosueAudor.IRespository.ICustomerProductRespository;
import com.sena.JosueAudor.IService.ICustomerProductService;

@Service
public class CustomerProductService implements ICustomerProductService {

    @Autowired
    private ICustomerProductRespository customerProductRepository;
    
    @Override
    public List<CustomerProduct> findAll() {
        return customerProductRepository.findAll();
    }

    @Override
    public Optional<CustomerProduct> findById(Long id) {
        return customerProductRepository.findById(id);
    }

    @Override
    public CustomerProduct save(CustomerProduct customerProduct) {
        return customerProductRepository.save(customerProduct);
    }

    @Override
    public void update(CustomerProduct customerProduct, Long id) {
        //Validar si
        Optional<CustomerProduct> op = customerProductRepository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else{
            //Crear nuevo objeto que va a contener los datos que se van actualizar
            CustomerProduct customerProductUpdate = op.get();
            customerProductUpdate.setCustomerId(customerProduct.getCustomerId());
            customerProductUpdate.setProductId(customerProduct.getProductId());
            customerProductUpdate.setBalance(customerProduct.getBalance());
            
            //Actualizar el objeto
            customerProductRepository.save(customerProductUpdate);
        }      
    }

    @Override
    public void delete(Long id) {
        //Eliminado lógico de los datos de "customerProduct"
        customerProductRepository.deleteById(id);
    }
    
}
