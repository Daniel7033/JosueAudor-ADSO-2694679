/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author Ambiente 209-2
 */
public class FunctionNumeric {

    private Double numero;

    private Double getNumero() {
        return numero;
    }

    private void setNumero(Double numero) {
        this.numero = numero;
    }

    private void InputNumeric(String mensaje, int tipo) {
        Boolean validar = false;
        FunctionString fs = new FunctionString();

        //Validar que se ingrese el dato correcto
        while (validar == false) {
            try {
                if (tipo == 1) {
                    this.setNumero(Double.parseDouble(fs.InputScanner(mensaje)));
                } else {
                    this.setNumero(Double.parseDouble(fs.InputJOptionPane(mensaje)));
                }
                validar = true;
            } catch (Exception e) {
                if (tipo == 1) {
                    fs.ShowScanner("Ha ingresado un dato no válido. ");
                } else {
                    fs.ShowJOptionPane("Ha ingresado un dato no válido. ");
                }
            }
        }
    }

    public Double InputDoubleNumericScanner(String mensaje) {
        InputNumeric(mensaje, 1);
        return this.getNumero();
    }

    public Double InputDoubleNumericJOptionPane(String mensaje) {
        InputNumeric(mensaje, 2);
        return this.getNumero();
    }

    public Double InputDoubleNumericRangeScanner(String mensaje, Double min, Double max) {
        do {
            InputNumeric(mensaje, 1);
        } while (this.getNumero() < min || this.getNumero() > max);
        return this.getNumero();
    }
    
    public Double InputDoubleNumericRangeJOptionPane(String mensaje, Double min, Double max) {
        do {
            InputNumeric(mensaje, 2);
        } while (this.getNumero() < min || this.getNumero() > max);
        return this.getNumero();
    }
    
    
    public Double InputDoubleNumericPositiveScanner(String mensaje) {
        do {
            InputNumeric(mensaje, 1);
        } while (this.getNumero() <= 0);
        
        return this.getNumero();
    }
    
    public Double InputDoubleNumericPositiveJOptionPane(String mensaje) {
        do {
            InputNumeric(mensaje, 2);
        } while (this.getNumero() <= 0);
        
        return this.getNumero();
    }
    
    public Double InputDoubleNumericNegativeScanner(String mensaje) {
        do {
            InputNumeric(mensaje, 1);
        } while (this.getNumero() >= 0);
        
        return this.getNumero();
    }
    
    public Double InputDoubleNumericNegativeJOptionPane(String mensaje) {
        do {
            InputNumeric(mensaje, 2);
        } while (this.getNumero() <= 0);
        
        return this.getNumero();
    }

    public Double InputNumericScanner(String grados_Celsius_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
