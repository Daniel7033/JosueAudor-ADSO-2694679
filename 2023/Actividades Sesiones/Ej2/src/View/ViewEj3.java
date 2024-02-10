/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Class.ClassEj3;
/**
 *
 * @author Ambiente 209-2
 */
public class ViewEj3 {
    public static void main(String[] args) {
        ClassEj3 obj1 = new ClassEj3();
        
        System.out.println("Digite el tiempo del Lunes:");
        obj1.setTiempo1(20);
        System.out.println("Digite el tiempo del miercoles:");
        obj1.setTiempo2(23);
        System.out.println("Digite el tiempo del Viernes:");
        obj1.setTiempo3(19);
        
        System.out.println("El tiempo promedio es de " + obj1.Mostrar() + " min.S");
    }
}
