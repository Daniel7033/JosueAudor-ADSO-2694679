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
public class ClassPar2 {

    private Double num;
    private String mensaje;

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void Mostrar() {
        Scanner x = new Scanner(System.in);

        double num;
        System.out.println(this.getMensaje());
        num = x.nextDouble();

        this.setNum(num);
        if (this.getNum() % 2 == 0) {
            if (this.getNum() > 0) {
                System.out.println("El número " + this.getNum() + " es par positivo");
            } else {
                System.out.println("El número " + this.getNum() + " es par negativo");

            }
        } else {
            if (this.getNum() % 2 != 0) {
                if (this.getNum() > 0) {
                    System.out.println("El número " + this.getNum() + " es impar positivo");
                } else {
                    System.out.println("El número " + this.getNum() + " es impar negativo");
                }
            }
        }

    }
}
