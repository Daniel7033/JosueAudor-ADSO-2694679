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
public class GradosC1 extends ClassGrados{
    
    @Override
    public Double Mostrar() {
        double celsius = 0;
        double fahren;
        fahren = (this.getCelsius() * 1.8 ) + 32;
        this.setFahren(fahren);
        this.setCelsius(celsius);
        return this.getFahren();
    }
    
}
