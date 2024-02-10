/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Scanner;

/**
 *
 * @author Ambiente 209-2
 */
public class Trabajos extends ClassNotas{

    @Override
    public Double Mostrar() {
        Scanner scan = new Scanner(System.in);
        double notas;
        System.out.println(this.getMensaje());
        
        notas = scan.nextDouble();
        
        this.setNum(notas);
        
        return super.Mostrar();
    }
    
}
