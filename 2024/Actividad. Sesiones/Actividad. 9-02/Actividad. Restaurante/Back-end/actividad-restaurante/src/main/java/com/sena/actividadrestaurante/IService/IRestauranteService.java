package com.sena.actividadrestaurante.IService;

import com.sena.actividadrestaurante.Entity.Restaurante;
import java.util.List;
import java.util.Optional;

public interface IRestauranteService {
    
    /**
     * Método para consultar todo
     */
    public List<Restaurante> findAll();
    
    /**
     * Método para consultar por "id"
     */
    public Optional<Restaurante> findById(Long id);
    
    /**
     * Método para consultar todo
     */
    public Restaurante save(Restaurante restaurante);
    
    /**
     * Método para modificar
     */
    public void update (Restaurante restaurante, Long id);
    
    /**
     * Método para eliminar
     */
    public void delete(Long id);
    
    /**
     * Método para eliminado lógico
     */
    public void deletedAt(Long id);
}
