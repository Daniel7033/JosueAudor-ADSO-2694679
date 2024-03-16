package com.sena.JosueAudor.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.JosueAudor.Entity.Product;
import com.sena.JosueAudor.IRespository.IProductRespository;
import com.sena.JosueAudor.IService.IProductService;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRespository productRepository;
    
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product Product) {
        return productRepository.save(Product);
    }

    @Override
    public void update(Product product, Long id) {
        //Validar si
        Optional<Product> op = productRepository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else{
            //Crear nuevo objeto que va a contener los datos que se van actualizar
            Product ProductUpdate = op.get();
            ProductUpdate.setName(product.getName());
            ProductUpdate.setDescription(product.getDescription());
            
            //Actualizar el objeto
            productRepository.save(ProductUpdate);
        }      
    }

    @Override
    public void delete(Long id) {
        //Eliminado lógico de los datos de "Product"
        productRepository.deleteById(id);
    }
    
}
