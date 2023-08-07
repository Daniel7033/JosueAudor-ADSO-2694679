/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Ambiente 209-2
 */
public class ClassEj2 {

    private Double pulsaciones;
    private Integer edad;
    private Integer segundos;

    ClassEj2() {

    }

    public ClassEj2(Integer edad, Integer segundos) {
        this.edad = edad;
        this.segundos = segundos;

    }

    public void Mostrar() {
        this.pulsaciones = (220 - this.edad) / this.segundos;
        System.out.println(this.pulsaciones);
    }
}
