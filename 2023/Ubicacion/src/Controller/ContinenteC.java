/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Model.Entity.Continente;


public class ContinenteC {
      public void Agregar(String postal, String descripcion){
        Continente state = new Continente();
        state.setCodigoPostal(postal);
        state.setDescripcion(descripcion);
        state.Agregar();
    }
    
    public void Modificar(Integer id, String postal, String descripcion){
        Continente state = new Continente();
        state.setId(id);
        state.setCodigoPostal(postal);
        state.setDescripcion(descripcion);
        state.Modificar();
    }
    
    public void Eliminar(Integer id){
        Continente state = new Continente();
        state.setId(id);
        state.Eliminar();
    }
    
}
