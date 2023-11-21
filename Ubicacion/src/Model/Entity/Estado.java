/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

import Conexion.Conexion;
import Model.Interfase.Accion;

/**
 *
 * @author Stork
 */
public class Estado implements Accion {

    private Integer id;
    private String codigoPostal;
    private String descripcion;
    //private Integer id;
    public Conexion conn = new Conexion();

    public Estado() {
    }

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

    @Override
    public void Agregar() {
        String sql;
        sql = "INSERT INTO estado ("
                + "codigo_postal, "
                + "descripcion "
                + ") VALUES ("
                + "' " + this.getCodigoPostal() + "', "
                + "' " + this.getDescripcion() + "' "
                + ");";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Modificar() {
        String sql;
        sql = "UPDATE estado SET "
                + "id = '" + this.getId() + "', "
                + "codigo_postal = '" + this.getCodigoPostal() + "', "
                + "descripcion = '" + this.getDescripcion() + "' "
                + "WHERE id = '" + this.getId() + "';";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public void Eliminar() {
        String sql;
        sql = "DELETE FROM estado "
                + "WHERE id = '" + this.getId() + "';";
        conn.ejecutarSQL(sql);
        conn.cerrarConexion();
    }

    @Override
    public Object Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
