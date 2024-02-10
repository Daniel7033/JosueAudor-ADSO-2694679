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
public class Transaccion extends Cuenta {

    private Double valorTransferencia;

    public Double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }
    /*Se deberia de encargar de verificar si la cuenta actualmente posee los fondos suficientes
    para poder efectuar un retiro y pregunta cuanto va a retirar el cliente*/
    public void VerificacionSaldo() {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        double retirar;
        retirar = fn.InputDoubleNumericPositiveScanner("¿Valor a retirar?: ");
        this.setValorTransferencia(retirar);
        if (retirar <= super.getSaldoInicial()) {
            double transaccion = super.getSaldoInicial();
            this.setSaldoActual(transaccion - retirar);
            this.Cuentas();
            this.ActualizarSaldo();

        } else {
            fs.ShowScanner("Saldo insuficiente");
        }
    }
    
    //Se deberia de encargar de "simplificar" las cuentas que son débito y crédito
    public void Cuentas() {
        String verdad = super.getTipoCuenta();
        if ("Credito".equals(verdad)) {
            this.Credito();
        } else if ("Dedito".equals(verdad)) {
            this.Debito();
        }
    }
    //La cuenta que es tipo crédito
    public void Credito() {
        FunctionString fs = new FunctionString();
        this.VerificacionSaldo();
        if (super.getTipoCuenta().equals("Credito")) {
            do {
                if (this.getValorTransferencia() >= 20000.0) {
                    fs.ShowJOptionPane("Cuenta Crédito.");
                } else {
                    fs.ShowScanner("Valor insuficiente para retirar.");
                }
            } while (false);
        }
    }
    //La cuenta que es tipo Débito
    public void Debito() {
        FunctionString fs = new FunctionString();
        this.VerificacionSaldo();
        if (super.getTipoCuenta().equals("Dedito")) {
            do {
                if (this.getValorTransferencia() >= 10000.0) {
                    fs.ShowJOptionPane("Cuenta Dédito.");
                } else {
                    fs.ShowScanner("Valor insuficiente para retirar.");
                }
            } while (false);
        }
    }
    //Se debería de encargar de llevar actualizado el saldo de la cuenta despues de cualquier retiro (no funciona por ahora)
    public void ActualizarSaldo() {
        FunctionString fs = new FunctionString();
        this.setSaldoActual(this.getSaldoInicial() - this.getValorTransferencia());
        fs.ShowScanner("Saldo Actual: " + this.getSaldoActual());
    }

}
