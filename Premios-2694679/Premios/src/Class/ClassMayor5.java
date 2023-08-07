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
public class ClassMayor5 {

    private Double num;
    private String mensaje;

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
        System.out.println(this.getMensaje());
        this.setNum(scan.nextDouble());
        do {
            System.out.println(this.getMensaje());
            this.setNum(scan.nextDouble());
        } while (this.getNum() <= 5);
        if (this.getNum() > 5) {
            System.out.println("Numero: " + this.getNum());
        }
    }

}
