/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Class.ClassNumero;

/**
 *
 * @author Stork
 */
public class ViewNumeros {
    public static void main(String[] args) {
        ClassNumero x = new ClassNumero();
        
        x.setMensaje1("Dígite el primer número: ");
        x.setMensaje2("Dígite el segundo número: ");
        x.Mostrar();
    }
}
