/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;

import Class.CapturaNumero;
import java.util.Arrays;

/**
 *
 * @author Ambiente 209-2
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Instanciar clase.
        CapturaNumero x = new CapturaNumero();
        Double a[], b[], c[];
        Integer cantidad, i;
        
        x.setMensaje("Digite el tamaño para los vectores a, b y c ");
        cantidad = x.Capturar().intValue();
        a = new Double[cantidad];
        b = new Double[cantidad];
        c = new Double[cantidad];
        
        for (i = 0; i < cantidad; i++) {
            x.setMensaje("A[" + i + "]: ");
            a[i] = x.Capturar();
            
        }
        
        for (i = 0; i < cantidad; i++) {
            x.setMensaje("B[" + i + "]: ");
            b[i] = x.Capturar();
            
        }
        
        for (i = 0; i < cantidad; i++) {
            c[i] = a[i] + b[i];
            
        }
        
        //Salida del programa
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        
    }
    
}
