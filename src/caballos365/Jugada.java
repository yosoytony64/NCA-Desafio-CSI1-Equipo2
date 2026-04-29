/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

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
   
    private double cantidadApostada;
    public static String caballoSeleccionado = "";
    public static double montoApostado = 0;
    public static int multiplicador = 1;

    public Jugada(double cantidadApostada) {
        
        this.cantidadApostada = cantidadApostada;
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
    
    public static void seleccionarCaballo(JLabel labelElegido, String nombre, JLabel[] todosLosLabels) {
        // 1. Guardamos la elección
        caballoSeleccionado = nombre;

        // 2. Limpiamos los bordes de todos los labels del array
        for (JLabel lbl : todosLosLabels) {
            lbl.setBorder(null);
        }

        // 3. Resaltamos el elegido con un borde grueso (ej: Color Oro)
        labelElegido.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 4));
        
        System.out.println("Caballo listo para la carrera: " + nombre);
    }
    
    public static void reiniciarApuesta() {
        caballoSeleccionado = "";
        montoApostado = 0;
        multiplicador = 1;
}
}
