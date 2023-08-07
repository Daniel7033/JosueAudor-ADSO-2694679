/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Scanner;

/**
 *
 * @author Ambiente 209-2
 */
public class CapturaNumero {

    private Double numero;
    private String mensaje;

    private void setNumero(Double numero) {
        this.numero = numero;

    }

    private Double getNumero() {
        return this.numero;

    }

    public String getMensaje() {
        return mensaje;

    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;

    }

    public Double Capturar() {
        Scanner scan = new Scanner(System.in);

        do {
            try {
                System.out.println(this.getMensaje());
                //Modificar el valor del atributo
                this.setNumero(Double.parseDouble(scan.next()));

                if (this.getNumero() <= 0) {
                    System.out.println("Dato inválido, solo números positivos.");

                }

            } catch (Exception e) {
                System.out.println("Dato no válido, no se admite caracteres alfanumericos.");
                this.setNumero(Double.parseDouble("0"));

            }
        } while (this.getNumero() <= 0);

        //Retornar el valor del atributo
        return this.getNumero();

    }

}
