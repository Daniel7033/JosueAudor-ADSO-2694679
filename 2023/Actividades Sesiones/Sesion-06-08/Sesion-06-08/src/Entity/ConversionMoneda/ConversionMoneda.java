/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.ConversionMoneda;

import Entity.Abstract.SuperEntity;
import Utils.FunctionNumeric;
import Utils.FunctionString;

/**
 *
 * @author Ambiente 209-2
 */
public class ConversionMoneda extends SuperEntity {

    private Double moendaLocal;

    private Double monedaExtranjera;

    //Objeto de la clase FunctionNumeric
    FunctionNumeric fn = new FunctionNumeric();
    
    //Objeto de la clase FunctionString
    FunctionString fs = new FunctionString();

    public Double getMoendaLocal() {
        return moendaLocal;
    }

    public void setMoendaLocal(Double moendaLocal) {
        this.moendaLocal = moendaLocal;
    }

    public Double getMonedaExtranjera() {
        return monedaExtranjera;
    }

    public void setMonedaExtranjera(Double monedaExtranjera) {
        this.monedaExtranjera = monedaExtranjera;
    }

    public void Pesos() {        
        this.setMoendaLocal(fn.InputDoubleNumericPositiveScanner("Digite la cantidad de peso(s) colombianos (COP): "));
        this.setMonedaExtranjera(this.getMoendaLocal()*0.0002415);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" COP a dólares: "+getMonedaExtranjera()+" (USD)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*62.28);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" COP a bolívares: "+getMonedaExtranjera()+" (VEF)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.0008846);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" COP a soles: "+getMonedaExtranjera()+" (PEN)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.03645);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" COP a pesetas: "+getMonedaExtranjera()+" (ESP)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.0002108);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" COP a francos: "+getMonedaExtranjera()+" (CHF)\n");
    }
    
    public void Dolares() {        
        this.setMoendaLocal(fn.InputDoubleNumericPositiveScanner("Digite la cantidad de dólar(es) (USD): "));
        this.setMonedaExtranjera(this.getMoendaLocal()*4000);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" USD a pesos colombianos: "+getMonedaExtranjera()+" (COP)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*1000);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" USD a bolívares: "+getMonedaExtranjera()+" (VEF)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*4.0);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" USD a soles: "+getMonedaExtranjera()+" (PEN)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*150);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" USD a pesetas: "+getMonedaExtranjera()+" (ESP)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.9);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" USD a francos: "+getMonedaExtranjera()+" (CHF)\n");
    }
    
    public void Bolivares() {        
        this.setMoendaLocal(fn.InputDoubleNumericPositiveScanner("Digite la cantidad de bólivar(es) (VEF): "));
        this.setMonedaExtranjera(this.getMoendaLocal()*0.01606);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" VEF a pesos colonbianos: "+getMonedaExtranjera()+" (COP)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.000003878);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" VEF a dólares: "+getMonedaExtranjera()+" (USD)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.0000142);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" VEF a soles: "+getMonedaExtranjera()+" (PEN)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.0005853);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" VEF a pesetas: "+getMonedaExtranjera()+" (ESP)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.000003384);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" VEF a francos: "+getMonedaExtranjera()+" (CHF)\n");
    }
    
    public void Soles() {        
        this.setMoendaLocal(fn.InputDoubleNumericPositiveScanner("Digite la cantidad de sol(es) (PEN): "));
        this.setMonedaExtranjera(this.getMoendaLocal()*1130.42);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" PEN a pesos colombianos: "+getMonedaExtranjera()+"\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.273);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" PEN a dólares: "+getMonedaExtranjera()+" (USD)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*70398.11);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" PEN a bolívares: "+getMonedaExtranjera()+" (VEF)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*41.2);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" PEN a pesetas: "+getMonedaExtranjera()+" (ESP)\n");
        this.setMonedaExtranjera(this.getMoendaLocal()*0.2383);
        fs.ShowScanner("La conversión de "+getMoendaLocal()+" PEN a francos: "+getMonedaExtranjera()+" (CHF)\n");
    }    
    
}
