/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Areas;

/**
 *
 * @author Stork
 */
public class Circunferencia extends Area{
    private Double radio;

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double Area() {
        double area;
        area = Math.PI * Math.pow(this.getRadio(), 2);
        this.setArea(area);
        
        return this.getArea(); 
    }
    
    
}
