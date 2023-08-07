/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Entity.ConversionMoneda.ConversionMoneda;

/**
 *
 * @author Ambiente 209-2
 */
public class MostrarMoneda {
    public static void main(String[] args) {
        ConversionMoneda cm = new ConversionMoneda();
        cm.Pesos();
        cm.Dolares();
        cm.Bolivares();
        cm.Soles();
    }
}
