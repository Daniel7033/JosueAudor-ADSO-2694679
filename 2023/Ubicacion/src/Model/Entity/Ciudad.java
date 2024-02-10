package Model.Entity;

import Conexion.Conexion;
import Model.Interfase.Accion;

public class Ciudad implements Accion{
    
    private Integer id;
    private String codigoPostal;
    private String descripcion;
    private Integer estadoId;
    Conexion conn = new Conexion();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }
    
    
    @Override
    public void Agregar() {
        String sql;
        sql = "INSERT INTO ciudad ("
                + "codigo_postal, "
                + "descripcion, "
                + "estado_id "
                + ") VALUES ("
                + "' " + this.getCodigoPostal() + "', "
                + "' " + this.getDescripcion() + "', "
                + " " + this.getEstadoId() + " "
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;
        sql = "UPDATE ciudad SET "
                + "id = '" + this.getId() + "', "
                + "codigo_postal = '" + this.getCodigoPostal() + "', "
                + "descripcion = '" + this.getDescripcion() + "', "
                + "estado_id = " + this.getEstadoId() + " "
                + "WHERE id = '" + this.getId() + "';";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
        String sql;
        sql = "DELETE FROM ciudad "
                + "WHERE id = '" + this.getId() + "';";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }
    @Override
    public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
