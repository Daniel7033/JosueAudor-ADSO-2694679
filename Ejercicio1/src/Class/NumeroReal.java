/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;



/**
 *
 * @author Ambiente 209-2
 */
public abstract class NumeroReal {
    
    private Double n1;
    private Double n2;
    private Double r;

    public Double getN1() {
        
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    protected Double getR() {
        return r;
    }

    protected void setR(Double r) {
        this.r = r;
    }
    
    public Double GenerarResultado(){
        return null;
    }
    
}
