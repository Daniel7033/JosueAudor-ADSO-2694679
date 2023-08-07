/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grados.Class.GradoFahrenheit;

import Grados.Class.ClassGrados;

/**
 *
 * @author Ambiente 209-2
 */
public class GradosF1 extends ClassGrados {

    @Override
    public Double Mostrar() {
        double fahren = 0;
        double celsius;
        celsius = (this.getFahren() - 32) / 1.8;
        this.setCelsius(celsius);
        this.setFahren(fahren);
        return super.getCelsius();
    }

}
