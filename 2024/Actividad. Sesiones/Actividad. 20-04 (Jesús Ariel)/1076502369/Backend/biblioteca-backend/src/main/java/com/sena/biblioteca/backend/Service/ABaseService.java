package com.sena.biblioteca.backend.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.sena.biblioteca.backend.Entity.ABaseEntity;
import com.sena.biblioteca.backend.IRepository.IBaseRepository;
import com.sena.biblioteca.backend.IService.IBaseService;


/**
 * @param <T>
 * @return
 */
public abstract class ABaseService <T extends ABaseEntity> implements IBaseService<T> {
	
	/**
     * Retrieves the repository associated with the entity.
     * @param <T>
     * @return The repository associated with the entity.
     */
    protected abstract  IBaseRepository<T, Long> getRepository();
    
    /**
	 * @return 
	 * @throws Exception
	 */
    @Override
	public List<T> all() throws Exception{
		return getRepository().findAll();
	}
    
    /**
	 * @return 
	 * @throws Exception
	 */
    @Override
	public List<T> findByStateTrue() throws Exception{
    	return getRepository().findAll();
    }
    /**
     * Retrieves an entity by its ID.
     * @param id The ID of the entity to retrieve.
     * @return An Optional containing the entity, or empty if not found.
     * @throws Exception If an error occurs while retrieving the entity.
     */
    
     @Override
     public Optional<T> findById(Long Id) throws Exception{
    	 Optional<T> op = getRepository().findById(Id);
    	 
    	 if (op.isEmpty()) {
    		 throw new Exception("Registro no encontrado");
    	 }
    	 return op;
     }
     /**
      * Saves an entity.
      * @param entity The entity to save.
      * @return The saved entity.
      * @throws Exception If an error occurs while saving the entity.
      */
     @Override
     public T save(T entity) throws Exception {
         try {
             entity.setCreatedAt(LocalDateTime.now());
             entity.setCreatedBy((long)1); 
             return getRepository().save(entity);
         } catch (Exception e) {
             
             throw new Exception("Error al guardar la entidad: " + e.getMessage());
         }
     }
     
     /**
      * Updates an existing entity by its ID.
      * @param id The ID of the entity to update.
      * @param entity The updated entity.
      * @throws Exception If an error occurs while updating the entity.
      */
     @Override
     public void update(Long id, T entity) throws Exception {
         Optional<T> op = getRepository().findById(id);

         if (op.isEmpty()) {
             throw new Exception("Registro no encontrado");
         } else if (op.get().getDeletedAt() != null) {
             throw new Exception("Registro inhabilitado");
         }

         T entityUpdate = op.get();

         String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
         BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
         entityUpdate.setUpdatedAt(LocalDateTime.now());
         entityUpdate.setUpdatedBy((long)1); 
         getRepository().save(entityUpdate);
     }
     
     /**
      * Deletes an entity by its ID.
      * @param id The ID of the entity to delete.
      * @throws Exception If an error occurs while deleting the entity.
      */
     @Override
     public void delete(Long id) throws Exception {
         Optional<T> op = getRepository().findById(id);

         if (op.isEmpty()) {
             throw new Exception("Registro no encontrado");
         }

         T entityUpdate = op.get();
         entityUpdate.setDeletedAt(LocalDateTime.now());
         entityUpdate.setDeletedBy((long)1);

         getRepository().save(entityUpdate);
     }

         
}
