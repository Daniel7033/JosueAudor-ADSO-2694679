/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Stork
 */
public class Canciones extends Artista{
    private Integer idCancion;
    private String cancion;
    
    public Canciones(Integer idc, Integer idArtista, String cancion){
        super(idArtista, null);
        this.idCancion = idc;
        this.cancion = cancion;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }
}
