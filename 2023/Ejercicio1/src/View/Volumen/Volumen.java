/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Volumen;

import Class.CapturaNumero;
import Class.Volumenes.Cono;
import Class.Volumenes.Cilindro;
import Class.Volumenes.Esfera;
import Class.Volumenes.Cubo;

/**
 *
 * @author Stork
 */
public class Volumen {
    public static void main(String[] args) {
        //Capturar
        CapturaNumero x = new CapturaNumero();
        
        //Hallar el volumen del cubo}
        Cubo cubo = new Cubo();
        
        System.out.println("Cubo: ");
        x.setMensaje("Digite la base del cubo: ");
        cubo.setBase(x.Capturar());
        x.setMensaje("Digite la profundidad del cubo: ");
        cubo.setProfun(x.Capturar());
        x.setMensaje("Digite la altura del cubo: ");
        cubo.setAltura(x.Capturar());
        System.out.println("El volumen del cubo es: " + cubo.Volumen());
        
        //Hallar el volumen del esfera
        Esfera esfera = new Esfera();
        
        System.out.println("Esfera: ");
        x.setMensaje("Digite el radio de la esfera: ");
        esfera.setRadio(x.Capturar());
        System.out.println("El volumen de la esfera es: " + esfera.Volumen());
        
        //Hallar el volumen del cilindro
        Cilindro cilindro = new Cilindro();
        
        System.out.println("Cilindro: ");
        x.setMensaje("Digite el radio del cilindro: ");
        cilindro.setRadio(x.Capturar());
        x.setMensaje("Digite la altura del cilindro: ");
        cilindro.setAltura(x.Capturar());
        System.out.println("El volumen de la esfera es: " + cilindro.Volumen());
        
        //Hallar el volumen del cono
        Cono cono = new Cono();
        
        System.out.println("Cono: ");
        x.setMensaje("Digite el radio del cono: ");
        cono.setRadio(x.Capturar());
        x.setMensaje("Digite la altura del cono: ");
        cono.setAltura(x.Capturar());
        System.out.println("El volumen de la esfera es: " + cono.Volumen());
        
    }
}
