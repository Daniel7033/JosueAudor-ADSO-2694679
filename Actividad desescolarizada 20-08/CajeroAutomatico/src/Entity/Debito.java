/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Utils.FunctionNumeric;
import Utils.FunctionString;

/**
 *
 * @author Stork
 */
public class Debito extends Transaccion {
    int debito = 2;
    @Override
    public Double Cuenta() {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        this.setValorTransferencia(fn.InputDoubleNumericPositiveScanner("¿Valor a retirar?"));
        do {
            if (this.getValorTransferencia() > 10000.0) {
                fs.ShowJOptionPane("Cuenta Dédito.");
                fs.ShowScanner("Valor a retirar: " + this.getValorTransferencia());
            } else {
                fs.ShowScanner("Valor insuficiente para retirar.");
            }
        } while (false);

        return this.getValorTransferencia();
    }

}
