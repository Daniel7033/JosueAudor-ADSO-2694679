/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grados.View;

import Grados.Class.GradoFahrenheit.GradosF1;
import Grados.Class.GradoFahrenheit.GradosF2;
import Grados.Class.GradosCelsius.GradosC1;
import Grados.Class.GradosCelsius.GradosC2;
import Grados.Class.GradosKelvin.GradosK2;
import Grados.Class.GradosKelvin.GradosK1;
import Utils.FunctionNumeric;
import Utils.FunctionString;

/**
 *
 * @author Ambiente 209-2
 */
public class ViewMostrar {

    public static void main(String[] args) {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        
        fs.ShowJOptionPane("Celsius\n");
        
        GradosC1 gc1 = new GradosC1();
        fs.ShowScanner("Grados Celsius a Fahrenheit\n");
        gc1.setCelsius(fn.InputDoubleNumericScanner("Grados Celsius: "));
        fs.ShowScanner("Grados Fahrenheit: " + gc1.Mostrar() + "°\n");

        GradosC2 gc2 = new GradosC2();
        fs.ShowScanner("Grados Celsius a Kelvin\n");
        gc2.setCelsius(fn.InputDoubleNumericScanner("Grados Celsius: "));
        fs.ShowScanner("Grados Kelvin: " + gc2.Mostrar() + "°\n");
        
        fs.ShowJOptionPane("Fahrenheit\n");
        
        GradosF1 gf1 = new GradosF1();
        fs.ShowScanner("Grados Fahrenheit a Celsius\n");
        gf1.setFahren(fn.InputDoubleNumericScanner("Grados Fachrenheit: "));
        fs.ShowScanner("Grados Fahrenheit: " + gf1.Mostrar() + "°\n");

        GradosF2 gf2 = new GradosF2();
        fs.ShowScanner("Grados Fahrenheit a Kelvin\n");
        gf2.setFahren(fn.InputDoubleNumericScanner("Grados Fahrenheit: "));
        fs.ShowScanner("Grados Kelvin: " + gf2.Mostrar() + "°\n");

        fs.ShowJOptionPane("Kelvin\n");
        
        GradosK1 gk1 = new GradosK1();
        fs.ShowScanner("Grados Kelvin a Celsius\n");
        gk1.setKelvin(fn.InputDoubleNumericScanner("Grados Kelvin: "));
        fs.ShowScanner("Grados Celsius: " + gk1.Mostrar() + "°\n");

        GradosK2 gk2 = new GradosK2();
        fs.ShowScanner("Grados Kelvin a Fahrenheit\n");
        gk2.setKelvin(fn.InputDoubleNumericScanner("Grados Kelvin: "));
        fs.ShowScanner("Grados Fahrenheit: " + gk2.Mostrar() + "°\n");
    }
}
