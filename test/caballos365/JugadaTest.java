/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package caballos365;


import org.junit.Test;
import static org.junit.Assert.*;

public class JugadaTest {

    @Test
    public void testCalcularPremio() {

        // Arrange
        Jugada jugada = new Jugada(50);

        // Act
        double resultado = jugada.calcularPremio();

        // Assert
        assertEquals(100, resultado, 0.001);
    }

    @Test
    public void testReiniciarApuesta() {

        // Arrange
        Jugada.caballoSeleccionado = "Pegaso";
        Jugada.montoApostado = 200;
        Jugada.multiplicador = 3;

        // Act
        Jugada.reiniciarApuesta();

        // Assert
        assertEquals("", Jugada.caballoSeleccionado);
        assertEquals(0, Jugada.montoApostado, 0.001);
        assertEquals(1, Jugada.multiplicador);
    }

    @Test
    public void testSeleccionarCaballo() {

        // Arrange
        javax.swing.JLabel label = new javax.swing.JLabel();
        javax.swing.JLabel[] todos = new javax.swing.JLabel[]{label};

        // Act
        Jugada.seleccionarCaballo(label, "Pegaso", todos);

        // Assert
        assertEquals("Pegaso", Jugada.caballoSeleccionado);
    }
}
