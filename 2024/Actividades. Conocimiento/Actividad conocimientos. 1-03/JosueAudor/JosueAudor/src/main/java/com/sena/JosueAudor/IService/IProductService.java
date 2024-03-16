package com.sena.JosueAudor.IService;

import java.util.List;
import java.util.Optional;

import com.sena.JosueAudor.Entity.Product;

public interface IProductService {
    
    /* 
     * Metodo para BUSCAR TODOS los registros
     */
    List<Product> findAll();       

    /* 
     * Metodo para BUSCAR los registros por ID
     */
    public Optional<Product> findById(Long id);        

    /* 
     * Metodo para GUARDAR los registros
     */
    public Product save(Product product);        

    /* 
     * Metodo para ACTUALIZAR los registros
     */
    public void update(Product product, Long id);        

    /* 
     * Metodo para ELIMINAR/BORRAR los registros por ID
     */
    public void delete(Long id);

}
