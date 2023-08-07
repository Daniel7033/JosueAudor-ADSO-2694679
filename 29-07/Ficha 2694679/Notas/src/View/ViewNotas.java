/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.util.Scanner;
import Class.Trabajos;
import Class.ClassNotas;
/**
 *
 * @author Ambiente 209-2
 */
public class ViewNotas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClassNotas clase = new ClassNotas();
        int num;
        
        System.out.println("Cantidad de notas: ");
        num = scan.nextInt();
        
        Trabajos job = new Trabajos();
        
        for (int i = 1; i <= num; i++) {
            job.setMensaje("Nota " + i + ":");
            job.Mostrar();
        }
    }
}
