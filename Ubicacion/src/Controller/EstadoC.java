package Controller;

import Model.Entity.Estado;
import java.util.ArrayList;

public class EstadoC {

    //---------------------------
    ArrayList<Estado> lista;

    public EstadoC() {
        lista = new ArrayList();
    }

    public void Agregar2(Estado c) {
        lista.add(c);
    }
    //--------------------------------
    
    public void Agregar(String postal, String descripcion) {
        Estado state = new Estado();
        state.setCodigoPostal(postal);
        state.setDescripcion(descripcion);
        state.Agregar();
    }

    public void Modificar(Integer id, String postal, String descripcion) {
        Estado state = new Estado();
        state.setId(id);
        state.setCodigoPostal(postal);
        state.setDescripcion(descripcion);
        state.Modificar();
    }

    public void Eliminar(Integer id) {
        Estado state = new Estado();
        state.setId(id);
        state.Eliminar();
    }
}
