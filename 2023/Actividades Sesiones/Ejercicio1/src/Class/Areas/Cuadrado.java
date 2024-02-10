/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Areas;

/**
 *
 * @author Stork
 */
public class Cuadrado extends Area{
    private Double lado;

    public Double getLado() {
        return lado;
    }

    public void setLado(Double lado) {
        this.lado = lado;
    }

    @Override
    public Double Area() {
        double area;
        area = this.getLado() * this.getLado();
        this.setArea(area);
        
        return this.getArea();
    }
    
    
}
