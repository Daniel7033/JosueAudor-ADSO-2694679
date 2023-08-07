/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Volumenes;

/**
 *
 * @author Stork
 */
public class Esfera extends Volumen{

    @Override
    public Double Volumen() {
        double volumen;
        volumen = 4 / 3 /*1.33333333333*/  * Math.PI * Math.pow(this.getRadio(), 3) ;
        this.setVolumen(volumen);
        
        return this.getVolumen();
    }
    
}
