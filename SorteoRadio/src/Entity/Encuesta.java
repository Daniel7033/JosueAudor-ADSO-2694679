package Entity;

import Utils.FunctionNumeric;
import Utils.FunctionString;

public class Encuesta extends Colores {

    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Integer numboleta;

    public Encuesta(Integer idOyente, String nombreOyente, String apellidoOyente, Integer numboleta, String direccion, String color) {
        super(null, color);
        this.id = idOyente;
        this.nombre = nombreOyente;
        this.apellido = apellidoOyente;
        this.direccion = direccion;
        this.numboleta = numboleta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumboleta() {
        return numboleta;
    }

    public void setNumboleta(Integer numboleta) {
        this.numboleta = numboleta;
    }
    
}
