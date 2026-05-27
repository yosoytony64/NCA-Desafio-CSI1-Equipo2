package caballos365;

import javax.swing.SwingUtilities;

/**
 * Hilo que monitorea la reproducción de música para pasar a la siguiente canción automáticamente.
 */
public class Musica_thread extends Thread {
    private Musica_de_chill gui;

    public Musica_thread(Musica_de_chill gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Esperamos un segundo entre comprobaciones para no saturar la CPU
                Thread.sleep(1000);

                // Verificamos si el mediaPlayer existe
                if (gui.mediaPlayer != null) {
                    // Si el estado es PLAYING, comprobamos si ha llegado al final
                    if (gui.mediaPlayer.getStatus() == javafx.scene.media.MediaPlayer.Status.PLAYING) {
                        double actual = gui.mediaPlayer.getCurrentTime().toSeconds();
                        double total = gui.mediaPlayer.getTotalDuration().toSeconds();

                        // Si falta menos de un segundo para terminar o ya terminó
                        if (actual >= total - 0.5 && total > 0) {
                            SwingUtilities.invokeLater(() -> {
                                gui.siguienteCancion();
                            });
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Hilo de música interrumpido.");
                break;
            } catch (Exception e) {
                // Capturamos cualquier error para que el hilo no muera
                System.err.println("Error en el hilo de música: " + e.getMessage());
            }
        }
    }
}

