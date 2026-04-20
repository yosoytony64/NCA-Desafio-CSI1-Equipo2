/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;
import java.sql.Connection; // Usa la interfaz estándar
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alber
 */
public class Conexion {
   static String url="jdbc:mysql://localhost:3306/casino";
   static String user="root";
   static String pass="";
    
    public static Connection conectar() {
    Connection con = null;
    try {
        // Forzamos el driver por si acaso
        
        con = DriverManager.getConnection(url, user, pass);
        System.out.println("Conexión exitosa");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error interno: " + e.getMessage());
    }
    return con; // Si falla, devuelve null
}
}
