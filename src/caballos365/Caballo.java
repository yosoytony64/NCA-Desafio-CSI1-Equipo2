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
       double xActual = imagen.getX();
    int y = imagen.getY();
    
    // Velocidad inicial base
    double velocidadActual = 1.0; 
    int contador = 0;
    int duracionRacha = (int)(Math.random() * 100) + 50; // Cuánto tiempo mantendrá el ritmo

    while (xActual < meta && !hayGanador) {
        try {
            // 1. CADA CIERTO TIEMPO (RACHA LARGA), EL CABALLO CAMBIA DE RITMO
            if (contador >= duracionRacha) {
                // Definimos una nueva velocidad para los próximos segundos
                // Unos caballos irán a 0.5 (muy lentos) y otros a 2.8 (rápidos)
                double nuevaVelocidad = (Math.random() * 2.3) + 0.5;
                
                // Actualizamos la duración de la próxima racha
                duracionRacha = (int)(Math.random() * 100) + 50;
                contador = 0;
                
                // Suavizamos el cambio de velocidad (para que no pegue tirón)
                velocidadActual = (velocidadActual + nuevaVelocidad) / 2;
            }

            // 2. MOVIMIENTO CONSTANTE
            xActual += velocidadActual;
            imagen.setLocation((int) xActual, y);

            contador++;
            Thread.sleep(15); // Fluidez total

        } catch (InterruptedException e) {
            break;
        }
    }
        
        
    }   

    private void finalizarCarrera() {
        // Esto detendrá a los demás hilos y mostrará el mensaje
    javax.swing.JOptionPane.showMessageDialog(null, "¡Ha ganado el caballo: " + this.nombre + "!");
    }
}

