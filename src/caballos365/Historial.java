/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
/**
 *
 * @author alber
 */
public class Historial {

    //Para la tabla de movimientos
    public void cargarMovimientos(JTable tabla, String usuario) {

        DefaultTableModel modelo = new DefaultTableModel();
        
        //Añadmios las columnas que queremos
        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha");
        modelo.addColumn("Tipo");

        tabla.setModel(modelo);

        try {
            
            //conectamos con la base de datos
            Connection cn = Conexion.conectar();

            String sql =
            "SELECT * FROM Movimientos WHERE id_usuario = " +
            "(SELECT id_usuario FROM Usuarios WHERE nombre = ?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, usuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Object[] fila = new Object[6];
                
                //metemos la información de la BD dentro de las filas
                fila[0] = rs.getInt("id_movimientos");
                fila[1] = rs.getInt("id_usuario");
                fila[2] = rs.getDouble("monto");
                fila[3] = rs.getTimestamp("fecha");
                fila[4] = rs.getString("tipo_movimiento");

                modelo.addRow(fila);
            }
            //cambiamos el tamaño de las columnas
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(60);   
            tabla.getColumnModel().getColumn(1).setPreferredWidth(90);   
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);  
            tabla.getColumnModel().getColumn(3).setPreferredWidth(260);  
            tabla.getColumnModel().getColumn(4).setPreferredWidth(260);  

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
            "Error cargando movimientos: " + e.getMessage());
        }
    }

    //Para la tabla de las  Carreras
    
    public void cargarCarreras(JTable tabla) {
        
        //Creamos la tabla y las columnas
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Carrera");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        modelo.addColumn("Ganador");

        tabla.setModel(modelo);

        try {
            
                //conectamos con la base de datos
            Connection cn = Conexion.conectar();

            String sql =
            "SELECT c.id_carrera, c.fecha_hora, c.estado, " +
            "ca.nombre AS ganador " +
            "FROM Carreras c " +
            "LEFT JOIN Resultados r ON c.id_carrera = r.id_carrera " +
            "LEFT JOIN Caballos ca ON r.id_ganador = ca.id_caballo";

            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                //metemos la información de la base de datos en las filas
                Object[] fila = new Object[4];

                fila[0] = rs.getInt("id_carrera");
                fila[1] = rs.getTimestamp("fecha_hora");
                fila[2] = rs.getString("estado");
                fila[3] = rs.getString("ganador");

                modelo.addRow(fila);
                
            }
            
            //Cambiamos el tamaño de las columnas
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(70);  
            tabla.getColumnModel().getColumn(1).setPreferredWidth(210);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(110); 
            tabla.getColumnModel().getColumn(3).setPreferredWidth(350); 

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
            "Error cargando carreras: " + e.getMessage());
        }
    }
}


    

