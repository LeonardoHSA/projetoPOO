/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaBeans;

import interfaces.CalculaImposto;

/**
 *
 * @author Leonardo
 */
public class Funcionario extends Pessoa implements CalculaImposto {
    
    private double salario;
    private String pis;
    private String cargo;
    private double impostoSobreSalario;

    public void calculaImposto() {
        
        if(this.salario < 1000){
            this.impostoSobreSalario = this.salario * 0.05;
        } else if(this.salario > 1000 && this.salario < 3000){
            this.impostoSobreSalario = this.salario * 0.1;
        } else if(this.salario > 3000 && this.salario < 5000){
            this.impostoSobreSalario = this.salario * 0.15;
        } else{
            this.impostoSobreSalario = this.salario * 0.25;             
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getImpostoSobreSalario() {
        return impostoSobreSalario;
    }

    public void setImpostoSobreSalario(double impostoSobreSalario) {
        this.impostoSobreSalario = impostoSobreSalario;
    }

    
    
    
}
