package com.sena.JosueAudor.IService;

import java.util.List;
import java.util.Optional;

import com.sena.JosueAudor.Entity.CustomerProduct;

public interface ICustomerProductService {
    
    /* 
     * Metodo para BUSCAR TODOS los registros
     */
    List<CustomerProduct> findAll();       

    /* 
     * Metodo para BUSCAR los registros por ID
     */
    public Optional<CustomerProduct> findById(Long id);        

    /* 
     * Metodo para GUARDAR los registros
     */
    public CustomerProduct save(CustomerProduct customerCustomerProduct);        

    /* 
     * Metodo para ACTUALIZAR los registros
     */
    public void update(CustomerProduct customerProduct, Long id);        

    /* 
     * Metodo para ELIMINAR/BORRAR los registros por ID
     */
    public void delete(Long id);

}
