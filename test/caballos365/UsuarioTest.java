/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package caballos365;


import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void testCrearUsuario() {

        // Arrange
        Usuario usuario = new UsuarioTestImpl(1, "Carlos", "carlos@mail.com", 22);

        // Act & Assert
        assertEquals(1, usuario.getIDusuario());
        assertEquals("Carlos", usuario.getNombre());
        assertEquals("carlos@mail.com", usuario.getEmail());
        assertEquals(22, usuario.getEdad());
    }

    @Test
    public void testSettersUsuario() {

        // Arrange
        Usuario usuario = new UsuarioTestImpl(1, "Carlos", "mail@mail.com", 20);

        // Act
        usuario.setNombre("Pedro");
        usuario.setEmail("pedro@mail.com");
        usuario.setEdad(30);

        // Assert
        assertEquals("Pedro", usuario.getNombre());
        assertEquals("pedro@mail.com", usuario.getEmail());
        assertEquals(30, usuario.getEdad());
    }
}