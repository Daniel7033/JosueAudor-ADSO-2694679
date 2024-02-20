package com.sena.actividadrestaurante.Service;

import com.sena.actividadrestaurante.Entity.Restaurante;
import com.sena.actividadrestaurante.IRepository.IRestauranteRepository;
import com.sena.actividadrestaurante.IService.IRestauranteService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService implements IRestauranteService{
    
    @Autowired
    private IRestauranteRepository repository;
    
    @Override
    public List<Restaurante> findAll() {
        return repository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Restaurante> findById(Long id) {
        return repository.findById(id); }

    @Override
    public Restaurante save(Restaurante restaurante) {
        restaurante.setFechaCreacion(LocalDateTime.now());
        return repository.save(restaurante);
    }

    @SuppressWarnings("null")
    @Override
    public void update(Restaurante restaurante, Long id) {
        //Consultar si existe el registro
        Optional<Restaurante> op = repository.findById(id);
        if (op.isEmpty()) {
            System.out.println("El registro es inexistente.");
        } else {
            Restaurante updateRestaurante = op.get();
            updateRestaurante.setNombre(restaurante.getNombre());
            updateRestaurante.setDireccion(restaurante.getDireccion());
            updateRestaurante.setTipoCocina(restaurante.getTipoCocina());
            updateRestaurante.setMenu(restaurante.getMenu());
            updateRestaurante.setHorarioAtencion(restaurante.getHorarioAtencion());
            updateRestaurante.setCapacidad(restaurante.getCapacidad());
            updateRestaurante.setFechaModificacion(LocalDateTime.now());
            
            repository.save(updateRestaurante);
        }
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public void deletedAt(Long id) {
        //Consultar si existe el registro
        Optional<Restaurante> op = repository.findById(id);
        if (op.isEmpty()) {
            System.out.println("El registro es inexistente y no puede ser eliminado.");
        } else {
            Restaurante updateRestaurante = op.get();
            updateRestaurante.setFechaEliminacion(LocalDateTime.now());
            repository.save(updateRestaurante);
        }
    }
    
}
