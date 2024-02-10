/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Class.Division;
import Class.Mod;
import Class.Multiplicacion;
import Class.Potencia;
import Class.Resta;
import Class.Suma;

/**
 *
 * @author Ambiente 209-2
 */
public class Operaciones {
    public static void main(String[] args) {
        
        Potencia potencia = new Potencia();
        potencia.setN1(2.0);
        potencia.setN2(3.0);
        System.out.println(potencia.GenerarResultado());
        
        Suma suma = new Suma();
        suma.setN1(2.0);
        suma.setN2(3.0);
        System.out.println(suma.GenerarResultado());
        
        Resta resta = new Resta();
        resta.setN1(2.0);
        resta.setN2(3.0);
        System.out.println(resta.GenerarResultado());
        
        Multiplicacion multiplicacion = new Multiplicacion();
        multiplicacion.setN1(2.0);
        multiplicacion.setN2(3.0);
        System.out.println(multiplicacion.GenerarResultado());
        
        Division division = new Division();
        division.setN1(2.0);
        division.setN2(3.0);
        System.out.println(division.GenerarResultado());
        
        Mod mod = new Mod();
        mod.setN1(2.0);
        mod.setN2(3.0);
        System.out.println(mod.GenerarResultado());
        
    }
}
