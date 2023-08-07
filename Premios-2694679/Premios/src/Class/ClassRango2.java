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
public class ClassRango2 {

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
        Scanner scan = new Scanner(System.in);
        double num;

        System.out.println(this.getMensaje());
        num = scan.nextDouble();

        this.setNum(num);

        do {
            System.out.println(this.getMensaje());
            num = scan.nextDouble();
            this.setNum(num);
        } while (this.getNum() > 300 || this.getNum() < 200);

        if (this.getNum() % 2 == 0) {
            System.out.println(this.getNum() + " es un número par");
        } else {
            System.out.println(this.getNum() + " es un número impar");
        }
    }
}
