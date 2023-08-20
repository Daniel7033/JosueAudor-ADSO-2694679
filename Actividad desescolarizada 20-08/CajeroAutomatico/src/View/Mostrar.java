/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Entity.Cuenta;
import Entity.Registro;

/**
 *
 * @author Stork
 */
public class Mostrar {
    public static void main(String[] args) {
        Cuenta c = new Cuenta();
        Registro r = new Registro();
        c.RegistroNuevosClientes();
        r.MostrarTransaccion();
    }
}

/*
El trabajo quedó incompleto faltando ciertas configuraciones y pruebas
*/
