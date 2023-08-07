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
public class ClassNumero {
    private Double num;
    private String mensaje1;
    private String mensaje2;
    
    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getMensaje1() {
        return mensaje1;
    }

    public void setMensaje1(String mensaje1) {
        this.mensaje1 = mensaje1;
    }

    public String getMensaje2() {
        return mensaje2;
    }

    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }
    
    public void Mostrar(){
        Scanner scan = new Scanner(System.in);
        double num1;
        double num2;
        
        System.out.println(this.getMensaje1());
        num1 = scan.nextDouble();
        this.setNum(num1);
        System.out.println(this.getMensaje2());
        num2 = scan.nextDouble();
        this.setNum(num2);
        
        if (num1 > num2) {
            System.out.println(num1 + " es mayor que " + num2);
        } else {
            System.out.println(num2 + " es mayor que " + num1);
        }
    }
}
