package com.sena.ventaautos.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.sena.ventaautos.Entity.ABaseEntity;
import com.sena.ventaautos.IRepository.IBaseRepository;
import com.sena.ventaautos.IService.IBaseService;

public abstract class ABaseService<T extends ABaseEntity> implements IBaseService<T> {

    protected abstract IBaseRepository<T, Long> getRepository();

    @Override
    public List<T> all() throws Exception {
        return getRepository().findAll();
    }

    @Override
    public List<T> findByStateTrue() throws Exception {
        return getRepository().findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<T> findById(Long id) throws Exception {
        Optional<T> op =  getRepository().findById(id);
        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        }
        return op;
    }

    @Override
    public T save(T entity) throws Exception {
        try {
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long)1);
            return getRepository().save(entity);
        } catch (Exception e) {
            throw new Exception("Error al guardar la entidad " + e.getMessage());
        }
    }

    @SuppressWarnings("null")
    @Override
    public void update(Long id, T entity) throws Exception {
        Optional<T> op = getRepository().findById(id);
        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null){
            throw new Exception("Registro inhabilitado");
        }
        T entityUpdate = op.get();
        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setUpdatedAt(LocalDateTime.now());
        entityUpdate.setUpdatedBy((long)id);
        getRepository().save(entityUpdate);
    }
    
    @SuppressWarnings("null")
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
