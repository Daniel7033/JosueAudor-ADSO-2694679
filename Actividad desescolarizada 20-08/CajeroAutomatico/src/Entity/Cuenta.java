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
public class Cuenta extends Cliente {

    private Integer bancoAfiliado;
    private Double saldoInicial = 100000.0;
    //private TipoCuenta tipoCuenta;

    public Integer getBancoAfiliado() {
        return bancoAfiliado;
    }

    public void setBancoAfiliado(Integer bancoAfiliado) {
        this.bancoAfiliado = bancoAfiliado;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public void RegistroNuevosClientes() {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();

        super.setNombre(fs.InputScanner("Nombre: "));
        //this.setNumCuenta(fn.InputIntegerNumericPositiveScanner("Numero de Cuenta (Numero de Identidad):"));
        this.TipoCuenta();
        this.Bancos();
        this.getSaldoInicial();
    }

    public void TipoCuenta() {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        do {
            super.setTipoCuenta(fs.InputScanner("Digite Credito/Debito: "));
        } while (!(super.getTipoCuenta().equals("Credito") || super.getTipoCuenta().equals("Debito")));
       
    }

    public void Bancos() {
        FunctionString fs = new FunctionString();
        FunctionNumeric fn = new FunctionNumeric();
        fs.ShowScanner("1- Banco XRL8. \n");
        fs.ShowScanner("2- Banco Tatuhi. \n");
        fs.ShowScanner("3- Banco La Federación. \n");
        fs.ShowScanner("4- Banco R2D2. \n");
        this.setBancoAfiliado(fn.InputIntegerNumericRangeScanner("Banco a afiliar: ", 1.0, 4.0));
        do {
            switch (this.getBancoAfiliado()) {
                case 1:
                    fs.ShowScanner("Banco XRL8. \n");
                    break;
                case 2:
                    fs.ShowScanner("Banco Tatuhi. \n");
                    break;
                case 3:
                    fs.ShowScanner("Banco La Federación. \n");
                    break;
                case 4:
                    fs.ShowScanner("Banco R2D2. \n");
                    break;
                default:
                    break;
            }
        } while (!(this.getBancoAfiliado() < 5));
    }

}
