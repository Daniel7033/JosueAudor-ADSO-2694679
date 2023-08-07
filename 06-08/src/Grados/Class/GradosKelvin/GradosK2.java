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
public class GradosK2 extends ClassGrados{

    @Override
    public Double Mostrar() {
        double kelvin = 0;
        double fahren;
        fahren = ((this.getKelvin() - 273.15) * 1.8) + 32;
        this.setKelvin(kelvin);
        this.setFahren(fahren);
        return super.getFahren();
    }
    
}
