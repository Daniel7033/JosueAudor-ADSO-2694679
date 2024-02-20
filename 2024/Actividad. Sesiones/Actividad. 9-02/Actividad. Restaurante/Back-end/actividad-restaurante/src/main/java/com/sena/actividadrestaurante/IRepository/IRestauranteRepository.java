package com.sena.actividadrestaurante.IRepository;

import com.sena.actividadrestaurante.Entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestauranteRepository extends JpaRepository<Restaurante, Long>{
    
}
