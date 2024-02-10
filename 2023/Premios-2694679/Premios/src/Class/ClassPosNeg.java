/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Scanner;

/**
 *
 * @author Stork
 */
public class ClassPosNeg {

    //ATRIBUTOS
    private Double num;
    private String mensaje;

    //ENCAPSULAMIENTO DE LOS ATRIBUTOS
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public void Mostrar() {
        Scanner scan = new Scanner(System.in);
        //Aquí se definen las variables
        double num;
        //Se muestra el mensaje desde la clase
        System.out.println(this.getMensaje());
        num = scan.nextDouble();
        this.setNum(num);
        if (num == 0) {
            System.out.println("El número " + this.getNum() + " no tiene un valor POSITIVO o NEGATIVO.");
        } else {
            if (num > 0) {
                System.out.println("El número " + this.getNum() + " es POSITIVO.");
            } else {
                System.out.println("El número " + this.getNum() + " es NEGATIVO.");
            }
        }
    }
}
