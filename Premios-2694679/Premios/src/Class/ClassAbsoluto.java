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
public class ClassAbsoluto {
    
    //ATRIBUTOS
    private Double num;
    private Double resultado;
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

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
    
    public void Mostrar() {
        Scanner scan = new Scanner(System.in);
        //Aquí se definen las variables
        double num;
        double resultado;
        //Se muestra el mensaje desde la clase
        System.out.println(this.getMensaje());
        num = scan.nextDouble();
        //Math.abs(), permite calcular el valor absoluto de cualquier número real
        resultado = Math.abs(num);
        this.setResultado(resultado);
        this.setNum(num);
        System.out.println("El valor absoluto de " + this.getNum() + " es " + this.getResultado());
    }
}
