/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;

/**
 *
 * @author Jorge
 */
public class Cliente extends Usuario{
    private String username;
    private double saldo;

    public Cliente(String username, double saldo, int IDusuario, String nombre, String email, int edad) {
        super(IDusuario, nombre, email, edad);
        this.username = username;
        this.saldo = saldo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
