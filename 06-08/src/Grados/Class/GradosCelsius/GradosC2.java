/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grados.Class.GradosCelsius;

import Grados.Class.ClassGrados;

/**
 *
 * @author Ambiente 209-2
 */
public class GradosC2 extends ClassGrados{

    @Override
    public Double Mostrar() {
        double celsius = 0;
        double kelvin;
        kelvin = this.getCelsius() + 273.15;
        this.setKelvin(kelvin);
        this.setCelsius(celsius);
        return this.getKelvin();
    }
    
}
