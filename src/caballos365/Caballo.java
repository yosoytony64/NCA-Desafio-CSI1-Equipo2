/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
                // nueva velocidad para los próximos segundos
                // Unos caballos irán a 0.5 (muy lentos) y otros a 2.3 (rápidos)
                double nuevaVelocidad = (Math.random() * 2.3) + 0.5;
                
                // Actualizamos la duración de la próxima racha
                duracionRacha = (int)(Math.random() * 100) + 50;
                contador = 0;
                
                // Suavizamos el cambio de velocidad, asi no pegara tiro)
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
        if (xActual >= meta && !hayGanador) {
        hayGanador = true; // Bloqueamos a los demás hilos
        
        // Llamamos a una función para repartir premios
        finalizarCarrera(this.nombre); 
    }
    }   
    
    
    
    private void finalizarCarrera(String ganador) {
    // Comprobamos si el usuario apostó por este caballo
    
    if (ganador.equalsIgnoreCase(pantalla.caballoApostado)) {
        double premio = pantalla.montoApuesta * pantalla.multiplicador;
        pantalla.saldoApp += premio;
        
        JOptionPane.showMessageDialog(null, "¡GANASTE! El caballo " + ganador + " llegó primero.\n"
                + "Premio: " + premio + " Auras.");
    } else {
        JOptionPane.showMessageDialog(null, "Ha ganado el caballo " + ganador + ".\n"
                + "Has perdido la carrera.");
        // El saldo se resta al momento de darle a "Correr"
    }

    // Actualizamos la base de datos inmediatamente
    actualizarSaldoBD db = new actualizarSaldoBD(); 
    db.actualizarSaldo(pantalla.usuarioIdentificado, pantalla.saldoApp);
    
    // Resetear para la siguiente carrera
    hayGanador = false; 
}
    
}




