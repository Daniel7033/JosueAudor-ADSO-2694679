package com.sena.actividadrestaurante.Controller;

import com.sena.actividadrestaurante.Entity.Restaurante;
import com.sena.actividadrestaurante.IService.IRestauranteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/restaurante")
public class RestauranteController {

    @Autowired
    private IRestauranteService service;

    @GetMapping
    public List<Restaurante> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Restaurante> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Restaurante save(@RequestBody Restaurante restaurante){
        return service.save(restaurante);
    }    

    @PutMapping("{id}")
    public void save(@RequestBody Restaurante restaurante, @PathVariable Long id){
        service.update(restaurante, id);
    }
    
    @PutMapping("deleted-at/{id}")
    public void deletedAt(@PathVariable Long id){
        service.deletedAt(id);
    }
    
    @DeleteMapping
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
    
}
