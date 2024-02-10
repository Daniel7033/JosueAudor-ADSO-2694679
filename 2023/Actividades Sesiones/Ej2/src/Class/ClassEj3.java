/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Ambiente 209-2
 */
public class ClassEj3 {
    private Double promedio;
    private Integer tiempo1;
    private Integer tiempo2;
    private Integer tiempo3;
    
    public ClassEj3(){
    }

    private Double getPromedio() {
        return promedio;
    }

    private void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Integer getTiempo1() {
        return tiempo1;
    }

    public void setTiempo1(Integer tiempo1) {
        this.tiempo1 = tiempo1;
    }

    public Integer getTiempo2() {
        return tiempo2;
    }

    public void setTiempo2(Integer tiempo2) {
        this.tiempo2 = tiempo2;
    }

    public Integer getTiempo3() {
        return tiempo3;
    }

    public void setTiempo3(Integer tiempo3) {
        this.tiempo3 = tiempo3;
    }
    
    public Double Mostrar(){
        
        this.setPromedio(((double) this.getTiempo1() + this.getTiempo2() + this.getTiempo3())/3);
        
        return this.getPromedio();
    }
    
    
}
