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
public class GradosF2 extends ClassGrados{

    @Override
    public Double Mostrar() {
        double fahren = 0;
        double kelvin;
        kelvin = ((this.getFahren() - 32) / 1.8) + 273.15;
        this.setFahren(fahren);
        this.setKelvin(kelvin);
        return super.getKelvin();
    }
    
}
