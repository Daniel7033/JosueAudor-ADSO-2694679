/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Volumenes;

/**
 *
 * @author Stork
 */
public class Cilindro  extends Volumen{
    
    @Override
    public Double Volumen() {
        double volumen;
        volumen = Math.PI * Math.pow(this.getRadio(), 2) * this.getAltura();
        this.setVolumen(volumen);
        
        return this.getVolumen();
    }
    
}
