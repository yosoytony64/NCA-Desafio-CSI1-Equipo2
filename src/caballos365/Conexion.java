/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alber
 */
public class Conexion {
   static String url="jdbc:mysql://localhost:3306/casino";
   static String user="root";
   static String pass="";
     private Connection conexion;
     
    public static Connection conectar() {
    Connection con = null;
    try {
       
        
        con = DriverManager.getConnection(url, user, pass);
        System.out.println("Conexión exitosa");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error interno: " + e.getMessage());
    }
    return con; 
}


 public ArrayList<Ongs> cargaraOngs() {
        ArrayList<Ongs> lista = new ArrayList<>();
        Connection con = conectar();
        if (con != null) {
            try {
                String sql = "SELECT id_ong, nombre, area , donacion_total";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()) {
                    Ongs og = new Ongs();
                    og.setId_ong(rs.getInt("id_ong"));
                    og.setNombre(rs.getString("nombre"));
                    og.setArea(rs.getString("area"));
                    og.setDonacion_total(rs.getString("donacion_total"));
                    
                    lista.add(og);
                }
                
                rs.close();
                st.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error al cargar los Articulos desde la base de datos:\n" + e.getMessage());
            } finally {
               
            }
        }
        return lista;
    }
}
