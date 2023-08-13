/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.RendimientoAcademico;

import Utils.FunctionNumeric;
import Utils.FunctionString;
/**
 *
 * @author Ambiente 209-2
 */
public class Alumno {
    private Double promedio;
    
    public String nivel;
    
    public Integer reprobado;

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getReprobado() {
        return reprobado;
    }

    public void setReprobado(Integer reprobado) {
        this.reprobado = reprobado;
    }
    
    
    public Double Estimulo(){
        return null;
    }
    public void EstimuloPreparatoria(){
        
        FunctionNumeric fn = new FunctionNumeric();
        FunctionString fs = new FunctionString();
        
        double promedio;
        int reprobado;
        promedio = fn.InputDoubleNumericScanner("Promedio: ");
        reprobado = fn.InputIntegerNumericPositiveScanner("Materias reprobadas: ");
        this.setPromedio(promedio);

        this.setReprobado(reprobado);

        if (this.getPromedio() >= 9.5) {
            fs.ShowScanner("Podrá cursar 55 unidades con un 25% de descuento. /n");

        } else {
            if (this.getPromedio() > 9.0 && this.getPromedio() < 9.5) {
                fs.ShowScanner("Podrá cursar 50 unidades con un 10% de descuento. /n");
            } else {
                if (this.getPromedio() > 7 && this.getPromedio() < 9) {
                    fs.ShowScanner("Podrá cursar 50 unidades sin descuento. /n");
                } else {
                    if (this.getPromedio() < 7 && this.getReprobado() < 4) {
                        fs.ShowScanner("Podrá cursar 45 unidades sin descuento. /n");
                    } else {
                        if (this.getPromedio() < 7 && this.getReprobado() > 3) {
                            fs.ShowScanner("Podrá cursar 40 unidades sin descuento. /n");
                        }
                    }
                }
            }
        }
    }
    public void EstimuloProfesional(){
        
        FunctionNumeric fn = new FunctionNumeric();
        FunctionString fs = new FunctionString();
        double promedio;
        promedio = fn.InputDoubleNumericScanner("Promedio: ");
        this.setPromedio(promedio);

        if (this.getPromedio() >= 9.5) {
            fs.ShowScanner("Podrá cursar 55 unidades con un 20% de descuento.");
        } else {
            if (this.getPromedio() < 9.5) {
                fs.ShowScanner("Podrá cursar 55 unidades sin descuento.");
            }
        }
    }
}
