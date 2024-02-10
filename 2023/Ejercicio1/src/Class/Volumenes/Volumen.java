/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class.Volumenes;

/**
 *
 * @author Stork
 */
public class Volumen {
    private Double volumen;
    
    private Double radio;
    private Double altura;
    private Double profun;
    private Double base;
    
    //RADIO
    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }
    
    //ALTURA
    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    //PROFUNDIDAD
    public Double getProfun() {
        return profun;
    }

    public void setProfun(Double profun) {
        this.profun = profun;
    }
    
    //BASE
    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }
    
    //VOLUMEN
    protected Double getVolumen() {
        return volumen;
    }

    protected void setVolumen(Double volumen) {
        this.volumen = volumen;
    }
    
    public Double Volumen(){
        return null;
    }
}
