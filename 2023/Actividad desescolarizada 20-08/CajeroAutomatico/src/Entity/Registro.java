/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Utils.FunctionNumeric;
import Utils.FunctionString;
import java.util.Date;

/**
 *
 * @author Stork
 */
public class Registro extends Transaccion {

    private Date fecha;
    private Double monto;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    //Debería de organizar el registro que guardara los datos y actualizara eventualmente, tambien deberia de normalizar los datos (no terminado)
    public void MostrarTransaccion() {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        this.Cuentas();
        this.ActualizarSaldo();

    }
}
