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
public class ClassRango {

    private Double num;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ClassRango() {
    }

    public ClassRango(Double num) {
        this.num = num;
    }

    public void Mostrar() {
        Scanner scan = new Scanner(System.in);

        System.out.println(this.getMensaje());
        this.num = scan.nextDouble();

        do {
            System.out.println(this.getMensaje());
            this.num = scan.nextDouble();
        } while (this.num > 100 || this.num < 50);
        if (this.num >= 50 && this.num <= 100) {
            System.out.println(this.num + " está entre 50 y 100.");
        }
    }
}
