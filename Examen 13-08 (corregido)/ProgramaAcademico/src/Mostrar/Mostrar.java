/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mostrar;

import Utilities.FunctionString;
import Class.RendimientoAcademico.Alumno;
import Utilities.FunctionNumeric;

/**
 *
 * @author Ambiente 209-2
 */
public class Mostrar {

    public static void main(String[] args) {
        FunctionNumeric fn = new FunctionNumeric();
        FunctionString fs = new FunctionString();
        Alumno al = new Alumno();
        al.setNivel(fs.InputScanner("Nivel academico: "));
        String nivel = al.getNivel();
        int resp;

        do {
            if ("preparatoria".equals(nivel)) {
                al.EstimuloPreparatoria();
            } else {
                if ("profesional".equals(nivel)) {
                    al.EstimuloProfesional();
                }
            }
            resp = fn.InputIntegerNumericPositiveJOptionPane("Desea continuar con los promedios?");
        } while (resp < 2);

    }
}
