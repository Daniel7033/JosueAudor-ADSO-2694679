/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Colegio;


import Utilities.FunctionNumeric;
import Utilities.FunctionString;


/**
 *
 * @author Ambiente 209-2
 */
public class Matricula extends Notas{
    private String nombre;
    private Double totalPagar;
    private Double porcentajeDescuento;
    private Byte cantidadUnidad;
    private Byte reprobadas;
    
    final Double costePreparatoria = 180.0;
    final Double costeProfesional = 300.0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    private void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    private Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    private void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    private Byte getCantidadUnidad() {
        return cantidadUnidad;
    }

    private void setCantidadUnidad(Byte cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
    }

    public Byte getReprobadas() {
        return reprobadas;
    }

    public void setReprobadas(Byte reprobadas) {
        this.reprobadas = reprobadas;
    }
    
    public void GenerarFactura(){
        this.CapturarDatos();
        
        
        if (super.getTipo().equals("Preparatoria")) {
            this.FacturaPreparatoria();
            this.setTotalPagar(costePreparatoria*(super.getPromedio()/5)*(1-this.getPorcentajeDescuento()));
        } else {
            this.FacturaProfesional();
            this.setTotalPagar(costeProfesional*(super.getPromedio()/5)*(1-this.getPorcentajeDescuento()));
        }
        
        
    }
    
    private void CapturarDatos(){
        FunctionNumeric fn = new FunctionNumeric();
        FunctionString fs = new FunctionString();
        
        this.setNombre(fs.InputScanner("Nombre del/la estudiante: "));
        do {
            
            super.setTipo(fs.InputScanner("Digite Preparatoria/Profesional: "));
        } while (!(super.getTipo().equals("Preparatoria") || super.getTipo().equals("Profesional")));
        super.setPromedio(fn.InputDoubleNumericRangeScanner("Digite el promedio: ", 0.0,10.0));
        if (super.getPromedio()<7&&super.getTipo().equals("Preparatoria")) {
            this.setReprobadas(fn.InputIntegerNumericRangeScanner("Digite la cantidad de materias reprobadas: 0/6 ", 0.0, 6.0).byteValue());
        }
    }
    
    public void FacturaPreparatoria(){
        if (super.getPromedio()>=9.5) {
            this.setPorcentajeDescuento(0.25);
            this.setCantidadUnidad((byte)55);
        } else if (super.getPromedio()<=9.0) {
            this.setPorcentajeDescuento(0.1);
            this.setCantidadUnidad((byte)50);
        } else if (super.getPromedio()>7.0) {
            this.setPorcentajeDescuento(0.0);
            this.setCantidadUnidad((byte)50);
        } else if (super.getPromedio()<=7.0 && this.getReprobadas()<=3) {
            this.setPorcentajeDescuento(0.0);
            this.setCantidadUnidad((byte)45);
        } else if (super.getPromedio()<=7.0 && this.getReprobadas()>3) {
            this.setPorcentajeDescuento(0.0);
            this.setCantidadUnidad((byte)40);
        }
    }
    
    public void FacturaProfesional(){
        if (super.getPromedio()>=9.5) {
            this.setPorcentajeDescuento(0.2);
            this.setCantidadUnidad((byte)55);
        } else if (super.getPromedio()<9.5) {
            this.setPorcentajeDescuento(0.0);
            this.setCantidadUnidad((byte)55);
        } 
    }
}
