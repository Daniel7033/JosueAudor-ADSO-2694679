package com.sena.JosueAudor.IService;

import java.util.List;
import java.util.Optional;

import com.sena.JosueAudor.Entity.Customer;

public interface ICustomerService {
    
    /* 
     * Metodo para BUSCAR TODOS los registros
     */
    List<Customer> all();       

    /* 
     * Metodo para BUSCAR los registros por ID
     */
    public Optional<Customer> findById(Long id);        

    /* 
     * Metodo para GUARDAR los registros
     */
    public Customer save(Customer customer);        

    /* 
     * Metodo para ACTUALIZAR los registros
     */
    public void update(Customer customer, Long id);        

    /* 
     * Metodo para ELIMINAR/BORRAR los registros por ID
     */
    public void delete(Long id);
}
