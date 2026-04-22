/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;

import javax.swing.JLabel;

/**
 *
 * @author Jorge
 */
public class Caballo extends Thread {
    private String nombre;
    private JLabel imagen; // El JLabel con el GIF
    private int meta;      // La coordenada X de la meta
    private static boolean hayGanador = false;
    
    public Caballo(String nombre, JLabel imagen, int meta) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.meta = meta;
        
}
    
    public void run() {
        int x = imagen.getX();
    int y = imagen.getY();
    int contadorPasos = 0;
    int rachaVelocidad = (int) (Math.random() * 4) + 1; // Su velocidad inicial

    while (x < meta && !hayGanador) {
        try {
            // 1. CADA 20 PASOS, EL CABALLO CAMBIA SU RITMO
            if (contadorPasos % 30 == 0) {
                // Puede ir lento (1) o pegar un sprint (hast 8)
                rachaVelocidad = (int) (Math.random() * 3) + 1; 
            }

            // 2. APLICAMOS EL MOVIMIENTO
            x += rachaVelocidad;
            imagen.setLocation(x, y);
            
            contadorPasos++;

            // 3. PAUSA CORTA PARA MANTENER FLUIDEZ
            Thread.sleep(15); 

        } catch (InterruptedException e) {
            break;
        }
    }

        // --- GESTIÓN DEL GANADOR ---
        // Usamos 'synchronized' para asegurarnos de que solo uno gana
        synchronized (Caballo.class) {
            if (x >= meta && !hayGanador) {
                hayGanador = true;
                finalizarCarrera();
            }
        }
        
        
    }   

    private void finalizarCarrera() {
        // Esto detendrá a los demás hilos y mostrará el mensaje
    javax.swing.JOptionPane.showMessageDialog(null, "¡Ha ganado el caballo: " + this.nombre + "!");
    }
}

