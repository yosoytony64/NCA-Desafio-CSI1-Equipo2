/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;

/**
 *
 * @author Jorge
 */
public class Jugada {
    private int idJugada;
    private Usuario IDusuario;
    private Carrera IDcarrera;
    private double monto;
    private String estado;
    private int idCaballoElegido;
    private double cantidadApostada;

    public Jugada(int idCaballoElegido, double cantidadApostada) {
        this.idCaballoElegido = idCaballoElegido;
        this.cantidadApostada = cantidadApostada;
    }

    public int getIdCaballoElegido() {
        return idCaballoElegido;
    }

    public void setIdCaballoElegido(int idCaballoElegido) {
        this.idCaballoElegido = idCaballoElegido;
    }

    public double getCantidadApostada() {
        return cantidadApostada;
    }

    public void setCantidadApostada(double cantidadApostada) {
        this.cantidadApostada = cantidadApostada;
    }

    // Método para calcular el premio
    public double calcularPremio() {
        return cantidadApostada * 2;
    }
}
