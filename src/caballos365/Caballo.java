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
        int x = imagen.getX(); // Posición inicial
        int y = imagen.getY();
        
        while (x < meta && !hayGanador) {
            try {
                // VELOCIDAD ALEATORIA: Generamos un salto aleatorio
                int salto = (int) (Math.random() * 15) + 1; // Salto de 1 a 15 píxeles
                x += salto;
                
                // Actualizamos la posición del GIF en la pantalla
                imagen.setLocation(x, y);
                
                // Hacemos una pausa pequeñita para que se vea el movimiento
                Thread.sleep(50); // Pausa de 50ms (ajusta esto para la velocidad general)

            } catch (InterruptedException e) {
                System.out.println("Error en el hilo del caballo: " + e.getMessage());
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

