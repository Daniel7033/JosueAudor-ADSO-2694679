/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Ambiente 209-2
 */
public class Suma extends NumeroReal{

    @Override
    public Double GenerarResultado() {
        this.setR(super.getN1() + super.getN2());
        return super.getR(); 
    }
    
}
