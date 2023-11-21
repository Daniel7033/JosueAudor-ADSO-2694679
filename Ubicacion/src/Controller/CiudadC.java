/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Entity.Ciudad;

/**
 *
 * @author Stork
 */
public class CiudadC {
     public void Agregar(String postal, String descripcion, Integer estadoId){
        Ciudad city = new Ciudad();
        city.setCodigoPostal(postal);
        city.setDescripcion(descripcion);
        city.setEstadoId(estadoId);
        city.Agregar();
    }
    
    public void Modificar(Integer id, String postal, String descripcion, Integer estadoId){
        Ciudad city = new Ciudad();
        city.setId(id);
        city.setCodigoPostal(postal);
        city.setDescripcion(descripcion);
        city.setEstadoId(estadoId);
        city.Modificar();
    }
    
    public void Eliminar(Integer id){
        Ciudad city = new Ciudad();
        city.setId(id);
        city.Eliminar();
    }
}
