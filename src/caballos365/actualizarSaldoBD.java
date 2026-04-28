/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jorge
 */
public class actualizarSaldoBD {
    public void actualizarSaldo(String nombre, double nuevoSaldo) {
        pantalla p = new pantalla();
        String sql = "UPDATE Usuarios SET saldo = ? WHERE nombre = ?";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, p.usuarioIdentificado);
            
            ps.executeUpdate();
            System.out.println("Saldo actualizado con éxito en la DB.");
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar saldo: " + e.getMessage());
        }
    
}
    
}
