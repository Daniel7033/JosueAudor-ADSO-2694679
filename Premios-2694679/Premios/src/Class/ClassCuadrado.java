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
public class ClassCuadrado {

    private Double num;
    private Double resultado;
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

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public void Mostrar() {
        Scanner scan = new Scanner(System.in);

        double num;
        double resultado;

        System.out.println(this.getMensaje());
        num = scan.nextDouble();

        resultado = Math.pow(num, 2);

        this.setResultado(resultado);
        this.setNum(num);

        do {
            System.out.println("El número " + this.getResultado() + " es menor a 5000.");
            System.out.println(this.getMensaje());
            num = scan.nextDouble();
            resultado = Math.pow(num, 2);
            this.setResultado(resultado);
            this.setNum(num);
        } while (this.getResultado() <= 5000);
        if (this.getResultado() > 5000) {
            System.out.println("Número: " + this.getNum());
            System.out.println("Número al cuadrado: " + this.getResultado());
        }
    }
}
