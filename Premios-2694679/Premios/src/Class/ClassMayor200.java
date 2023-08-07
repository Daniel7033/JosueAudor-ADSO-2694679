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
public class ClassMayor200 {

    private Double num;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ClassMayor200() {
    }

    public ClassMayor200(Double num) {
        this.num = num;
    }

    public void Mostrar() {
        Scanner scan = new Scanner(System.in);

        System.out.println(this.getMensaje());
        this.num = scan.nextDouble();

        if (this.num > 200) {
            System.out.println(this.num + " es MAYOR a 200.");
        } else {
            System.out.println("El número " + this.num + " es MENOR a 200.");
        }
    }
}
