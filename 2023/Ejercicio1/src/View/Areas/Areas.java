/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Areas;

import Class.Areas.Circunferencia;
import Class.Areas.Cuadrado;
import Class.Areas.Rectangulo;
import Class.Areas.Trapecio;
import Class.Areas.Triangulo;
import Class.CapturaNumero;

/**
 *
 * @author Stork
 */
public class Areas {

    public static void main(String[] args) {
        //Objeto para capturar datos
        CapturaNumero x = new CapturaNumero();

        //Hallar área del triángulo
        Triangulo triangulo = new Triangulo();
        System.out.println("Triangulo: ");
        x.setMensaje("Digite la base del triangulo: ");
        triangulo.setBase(x.Capturar());
        x.setMensaje("Digite la altura del triangulo: ");
        triangulo.setAltura(x.Capturar());
        System.out.println("El area del triangulo es: " + triangulo.Area());

        //Hallar área del rectángulo
        Rectangulo rectangulo = new Rectangulo();
        System.out.println("Rectángulo:");
        x.setMensaje("Digite la base del rectangulo: ");
        rectangulo.setBase(x.Capturar());
        x.setMensaje("Digite la altura del rectángulo: ");
        rectangulo.setAltura(x.Capturar());
        System.out.println("El area del rectángulo es: " + rectangulo.Area());
        
        //Hallar área de la circunferencia
        Circunferencia circunferencia = new Circunferencia();
        System.out.println("Circunferencia: ");
        x.setMensaje("Digite el radio de la circunferencia: ");
        circunferencia.setRadio(x.Capturar());
        System.out.println("El radio de la circunferencia es: " + circunferencia.Area());
        
        //Hallar área del trapecio
        Trapecio trapecio = new Trapecio();
        System.out.println("Trapecio: ");
        x.setMensaje("Digite la altura del trapecio: ");
        trapecio.setAltura(x.Capturar());
        x.setMensaje("Digite la base 1 del trapecio: ");
        trapecio.setBase1(x.Capturar());
        x.setMensaje("Digite la base 2 del trapecio: ");
        trapecio.setBase2(x.Capturar());
        System.out.println("El area del trapecio es: " + trapecio.Area());
        
        //Hallar el área de un cuadrado
        Cuadrado cuadrado = new Cuadrado();
        System.out.println("Cuadrado: ");
        x.setMensaje("Digite el valor de los lados del cuadrado: ");
        System.out.println("(El valor de 1 lado es igual al resto)");
        cuadrado.setLado(x.Capturar());
        System.out.println("El area del cuadrado es: " + cuadrado.Area());
    }
}
