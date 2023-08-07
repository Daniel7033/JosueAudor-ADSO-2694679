/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grados.Class.GradosKelvin;

import Grados.Class.ClassGrados;
/**
 *
 * @author Ambiente 209-2
 */
public class GradosK1 extends ClassGrados{

    @Override
    public Double Mostrar() {
        double kelvin = 0;
        double celsius;
        celsius = this.getKelvin() - 273.15;
        this.setCelsius(celsius);
        this.setKelvin(kelvin);
        return super.getCelsius();
    }
    
}
