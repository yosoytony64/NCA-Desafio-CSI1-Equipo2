/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package caballos365;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 *
 * @author alber
 */

public class pantalla extends javax.swing.JFrame {

Conexion con = new Conexion();
public static String usuarioIdentificado; // Se llenará al hacer Login
public static double saldoApp = 0.0;  // variable encargada de guardar el saldo de la app
public static String caballoApostado = ""; //Guarda el caballo que ha elegido el usuario
public static double montoApuesta = 0.0; //Guarda cuanta auta a elegido jugar el usuario
public static int multiplicador = 2; //Variable que multiplica x2 las ganancias(en caso de que gane)

int velocidad = 30; // Velocidad constante para ambos objetos usable para la meta y la salida
Historial historial = new Historial(); //Clase historial
Connection conexionReal = Conexion.conectar();
public static int idCarreraActual = 0;  



//Son los encargados de controlar el tiempo y el movimiento de la carrera para que los caballos no se muevan antes de tiempo.
private Timer timerCarrera;
private boolean carreraActiva = false;


private JLabel[] Caballo;

    public pantalla() {
        initComponents();
        con.conectar(); //Variable encargada de conectar la BD
        
        jLabel22.setText(String.valueOf(pantalla.saldoApp)); //Jlabel22 es donde se imprime el saldo 
        
        Caballo = new JLabel[]{jLabel17, jLabel18, jLabel19, jLabel20, jLabel21};//Guarda y agrupa los caballos
        
        //Botones de "Volver al menú" y "Volver" Deshabilitados
        jLabel27.setEnabled(false);
        jLabel28.setEnabled(false);
        
        //Color de las tablas
        jScrollPane1.getViewport().setBackground(new Color(222, 200, 161));
        jTable1.getTableHeader().setBackground(new Color(222, 200, 161));
        jTable1.getTableHeader().setForeground(new Color(44, 34, 22));
        jScrollPane2.getViewport().setBackground(new Color(222, 200, 161));
        jTable2.getTableHeader().setBackground(new Color(222, 200, 161));
        jTable2.getTableHeader().setForeground(new Color(44, 34, 22));
        
        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jDialog3 = new javax.swing.JDialog();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jDialog4 = new javax.swing.JDialog();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDialog5 = new javax.swing.JDialog();
        jTextField6 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jDialog6 = new javax.swing.JDialog();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDialog7 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jDialog1.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar1.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBar1.setForeground(new java.awt.Color(204, 204, 0));
        jProgressBar1.setMaximum(1400);
        jProgressBar1.setMinimum(150);
        jDialog1.getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 640, 1340, 50));

        jProgressBar2.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBar2.setForeground(new java.awt.Color(204, 0, 0));
        jProgressBar2.setMaximum(1400);
        jProgressBar2.setMinimum(150);
        jDialog1.getContentPane().add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 720, 1340, 50));

        jProgressBar3.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBar3.setForeground(new java.awt.Color(0, 102, 204));
        jProgressBar3.setMaximum(1400);
        jProgressBar3.setMinimum(150);
        jDialog1.getContentPane().add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 800, 1340, 50));

        jProgressBar4.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBar4.setForeground(new java.awt.Color(102, 0, 255));
        jProgressBar4.setMaximum(1400);
        jProgressBar4.setMinimum(150);
        jDialog1.getContentPane().add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 880, 1340, 50));

        jProgressBar5.setBackground(new java.awt.Color(204, 204, 204));
        jProgressBar5.setForeground(new java.awt.Color(0, 153, 0));
        jProgressBar5.setMaximum(1400);
        jProgressBar5.setMinimum(150);
        jDialog1.getContentPane().add(jProgressBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 960, 1340, 50));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/arribamarco (1).png"))); // NOI18N
        jLabel30.setText("jLabel29");
        jDialog1.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/volvermenu.png"))); // NOI18N
        jLabel27.setText("jLabel27");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jDialog1.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 400, 90));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GifsCaballos/SPRITES CABALLOS/verdebien-ezgif.com-resize.gif"))); // NOI18N
        jDialog1.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/volver.png"))); // NOI18N
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jDialog1.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 500, 340, 110));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/huecogrande.png"))); // NOI18N
        jDialog1.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/arribamarco (1).png"))); // NOI18N
        jLabel29.setText("jLabel29");
        jDialog1.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GifsCaballos/SPRITES CABALLOS/gifmoradobien-ezgif.com-resize.gif"))); // NOI18N
        jDialog1.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 160, 130));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GifsCaballos/SPRITES CABALLOS/AZULBIEN-ezgif.com-resize.gif"))); // NOI18N
        jDialog1.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GifsCaballos/SPRITES CABALLOS/ROJOBIEN-ezgif.com-resize.gif"))); // NOI18N
        jDialog1.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GifsCaballos/SPRITES CABALLOS/AMARILLOBIEN-ezgif.com-resize.gif"))); // NOI18N
        jDialog1.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/FONDOMETA.png"))); // NOI18N
        jDialog1.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(5000, 0, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/Diseño sin título (1).png"))); // NOI18N
        jLabel11.setRequestFocusEnabled(false);
        jDialog1.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1960, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondogif.gif"))); // NOI18N
        jLabel13.setText("jLabel13");
        jDialog1.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 540));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/fondo barras de progresored.png"))); // NOI18N
        jDialog1.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, -1, -1));

        jDialog2.setMinimumSize(new java.awt.Dimension(1920, 1080));

        jLabel3.setText("ADMIN");
        jDialog2.getContentPane().add(jLabel3, java.awt.BorderLayout.CENTER);

        jDialog3.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jDialog3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setBackground(new java.awt.Color(74, 47, 29));
        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        jTextField3.setName("USUARIO"); // NOI18N
        jDialog3.getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 590, 270, 40));

        jTextField5.setBackground(new java.awt.Color(74, 47, 29));
        jTextField5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);
        jTextField5.setName("USUARIO"); // NOI18N
        jDialog3.getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 490, 270, 40));

        jTextField2.setBackground(new java.awt.Color(74, 47, 29));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.setName("USUARIO"); // NOI18N
        jDialog3.getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 270, 40));

        jTextField4.setBackground(new java.awt.Color(74, 47, 29));
        jTextField4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);
        jTextField4.setName("USUARIO"); // NOI18N
        jDialog3.getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 270, 40));

        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jDialog3.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 703, 130, 30));

        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jDialog3.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 500, 360, 90));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/egitro.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jDialog3.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jDialog4.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jDialog4.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jDialog4.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 770, 620, 110));

        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jDialog4.getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 630, 140));

        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jDialog4.getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 427, 630, 150));

        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jDialog4.getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 600, 640, 140));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/MenuPrincipal1920 (1).png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jDialog4.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 1090));

        jDialog5.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jDialog5.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setBackground(new java.awt.Color(18, 14, 14));
        jTextField6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jDialog5.getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 750, 340, 70));

        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jDialog5.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 270, 190, 200));

        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        jDialog5.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 270, 190, 200));

        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jDialog5.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 190, 200));

        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jDialog5.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 180, 190));

        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jDialog5.getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 857, 430, 120));

        jButton16.setBackground(new java.awt.Color(204, 204, 204));
        jButton16.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 51, 51));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/BOTON VOLVER.png"))); // NOI18N
        jButton16.setToolTipText("");
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jDialog5.getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 180, 110));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/Aura (1).jpg"))); // NOI18N
        jLabel24.setText("jLabel24");
        jDialog5.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 920, 100, 120));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jDialog5.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, 350, 80));

        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jDialog5.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 276, 190, 190));

        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jDialog5.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 850, 440, 130));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/ImagenInscipcionCarreraBueno.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jLabel12.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel12.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel12.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jLabel12.setRequestFocusEnabled(false);
        jDialog5.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jDialog6.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jDialog6.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Impact", 1, 60)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("0");
        jDialog6.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 780, 50));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Aura (1).jpg"))); // NOI18N
        jDialog6.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 100, 110));

        jButton9.setText(" ");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jDialog6.getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 590, 100));

        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jDialog6.getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 910, 830, 90));

        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jDialog6.getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1235, 497, 590, 100));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/Aura (1).jpg"))); // NOI18N
        jDialog6.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 370, 100, 90));

        jTextField7.setBackground(new java.awt.Color(255, 255, 255));
        jTextField7.setFont(new java.awt.Font("Palatino Linotype", 0, 24)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(51, 51, 51));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jDialog6.getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 480, 90));

        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jDialog6.getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 680, 570, 80));

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setFont(new java.awt.Font("Palatino Linotype", 0, 24)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(51, 51, 51));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jDialog6.getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1237, 376, 580, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/MenuSaldoBueno.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jDialog6.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jDialog7.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jDialog7.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jDialog7.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jDialog7.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(24, 17, 12));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 51)));
        jScrollPane1.setForeground(new java.awt.Color(230, 195, 120));
        jScrollPane1.setOpaque(false);

        jTable1.setBackground(new java.awt.Color(222, 200, 161));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTable1.setForeground(new java.awt.Color(44, 34, 22));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_movimientos", "id_usuario", "monto", "fecha", "tipo_movimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable1.setAutoscrolls(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(60);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(90);
        }

        jDialog7.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 770, 560));

        jTable2.setBackground(new java.awt.Color(222, 200, 161));
        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTable2.setForeground(new java.awt.Color(44, 34, 22));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id_carrera", "fecha_hora", "estado", "ganador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(222, 200, 161));
        jTable2.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jDialog7.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 360, 750, 550));

        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jDialog7.getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 70, 250, 80));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caballos365/fondo historial.png"))); // NOI18N
        jLabel31.setText("jLabel31");
        jDialog7.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 720, 370, 50));

        jPasswordField1.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordField1.setName("CONTRASEÑA"); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 650, 360, 40));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setName("USUARIO"); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 360, 40));

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 830, 190, 20));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/IMAGEN (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 jDialog3.setVisible(true);  
 this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    //Este boton se encarga de controlar el inicio de sesion del usuario
    String usuarioInput = jTextField1.getText();
    String passInput = jPasswordField1.getText();
    
    //Verificacion de campos vacios
    if (!usuarioInput.equals("") && !passInput.equals("")) {
        try {
            Connection conexionReal = Conexion.conectar();
            
            // Consulta directa a una sola tabla, seleccion de tabla
            String sql = "SELECT saldo, nombre FROM Usuarios WHERE (nombre = ? OR email = ?) AND contraseña = ?";
            
            //Columnas de la tabla
            java.sql.PreparedStatement ps = conexionReal.prepareStatement(sql);
            ps.setString(1, usuarioInput);
            ps.setString(2, usuarioInput);
            ps.setString(3, passInput);
            
            ResultSet rs = ps.executeQuery(); 
            
            if (rs.next()) {
                // Guardamos el saldo y el nombre del usuario 
                pantalla.saldoApp = rs.getDouble("saldo"); 
                pantalla.usuarioIdentificado = rs.getString("nombre"); 
                
                // Abrimos el menú principal
                jDialog4.setVisible(true);
                this.setVisible(false); 
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pantalla obj_pantalla = new pantalla();
        obj_pantalla.setVisible(true);   
        jDialog3.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jDialog3.setVisible(false);
        
        //Este boton controla el registro
        //Variables donde se alamacenan los datos del usuario
        String nombre=jTextField2.getText();
        String edadTexto=jTextField3.getText();
        String email=jTextField5.getText();
        String contraseña=jTextField4.getText();
        
        //Validacion de campos en blanco
        if (nombre.isEmpty() || edadTexto.isEmpty() || email.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduce los datos");
        }else{
            try {
       
                
        //Restriccion de edad, si eres menor no te deja resgistrarte pasando la edatTexto a int        
        int edad = Integer.parseInt(edadTexto);
        
        
        if (edad < 18) {
            JOptionPane.showMessageDialog(null, "Debes ser mayor de edad");
            return;
        }
        
        //Conecta la base de datos
            Connection conexionReal = Conexion.conectar();

            String consulta = "INSERT INTO usuarios (nombre,edad,email,contraseña)values('"+nombre+"','"+edad+"','"+email+"','"+contraseña+"')";
            try {
                java.sql.PreparedStatement ps = conexionReal.prepareStatement(consulta);
                ps.executeUpdate();
                limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(pantalla.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "NO se han registrado los datos22") ;
            }catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Edad inválida");
    }

            try{
                JOptionPane.showMessageDialog(null, "Datos Guardados");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "NO se han registrado los datos") ;
            }
            
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "NO se han registrado los datos") ;
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
    jDialog4.setVisible(false);
    jDialog5.setVisible(true);
    jLabel22.setText(pantalla.saldoApp + " Auras");
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     
        
    jLabel27.setEnabled(false);
    jLabel28.setEnabled(false);
    
    
    if (carreraActiva) return;
    
    //Mensaje si no has confirmado la apuesta
    if (pantalla.montoApuesta <= 0) {
        JOptionPane.showMessageDialog(this, "Primero confirma apuesta");
        return;
    } 
    
    resetCarrera();
    carreraActiva = true;

    

    // parar timer anterior
    if (timerCarrera != null) timerCarrera.stop();

    timerCarrera = new Timer(10, e -> moverSalida()); //Llamamos al MoverSalida al empezar la carrera
    timerCarrera.start(); //iniciamos el timer

    jDialog1.setVisible(true);
    jDialog5.setVisible(false);

    int meta = 1400; //Posición donde pararan los caballos
    
    //Creamos los caballos
    Caballo c1 = new Caballo("Amarillo", jLabel7, meta, jProgressBar1);
    Caballo c2 = new Caballo("Rojo", jLabel6, meta, jProgressBar2);
    Caballo c3 = new Caballo("Azul", jLabel8, meta, jProgressBar3);
    Caballo c4 = new Caballo("Morado", jLabel5, meta, jProgressBar4);
    Caballo c5 = new Caballo("Verde", jLabel9, meta, jProgressBar5);
     
    
    //Conexión con la base de datos para guardar la carrera
    try {

        Connection cn = Conexion.conectar();

        String sql =
        "INSERT INTO Carreras(fecha_hora,estado) " +
        "VALUES(NOW(),'En curso')";

        PreparedStatement ps =
        cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if(rs.next()) {

            pantalla.idCarreraActual = rs.getInt(1);
        }

    } catch(Exception e) {

        JOptionPane.showMessageDialog(this,
        "Error creando carrera");
    }


    //iniciamos los caballos
    c1.start();
    c2.start();
    c3.start();
    c4.start();
    c5.start();
      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        jDialog4.setVisible(false);
        jDialog6.setVisible(true);
        jLabel14.setText(String.valueOf(pantalla.saldoApp)); // Muestra el saldo actual al abrir
        jDialog6.setVisible(true);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    public void actualizarLabelSaldo() {
    jLabel14.setText(String.valueOf(this.saldoApp) + " Auras");
}
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      //ESTE BOTON SE ENCARGA DE ACTUALIZAR EL SALDO
      try {
          //Variable donde guarda el monto
          double monto = Double.parseDouble(jTextField7.getText());

          //Sumamos a la variable de la app. Suma el antiguo salgo con el monto ganado
          pantalla.saldoApp += monto;

          //Guardar en la Base de Datos
         actualizarSaldoBD db = new actualizarSaldoBD();
          db.actualizarSaldo(pantalla.usuarioIdentificado, pantalla.saldoApp);

          JOptionPane.showMessageDialog(this, "Recarga de " + monto + " Auras completada.");
          jTextField7.setText(""); // Limpiamos el campo
  
          
  //Guardamos en la base de datos el movimiento realizado
  String sql =
  "INSERT INTO Movimientos(id_usuario,monto,tipo_movimiento) " +
  "VALUES((SELECT id_usuario FROM Usuarios WHERE nombre=?),?,?)";

  PreparedStatement ps = conexionReal .prepareStatement(sql);

  ps.setString(1, pantalla.usuarioIdentificado);
  ps.setDouble(2, monto);
  ps.setString(3, "Ingreso");

  ps.executeUpdate();


      } catch (Exception e) {
          JOptionPane.showMessageDialog(this, "Error: Introduce un número válido.");
      }

        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    
    jLabel14.setText(caballos365.pantalla.saldoApp + " Auras");
    jButton9.setEnabled(true);
    jTextField7.setText(""); // Limpiamos el cuadro de texto
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        jDialog4.setVisible(true);
        jDialog6.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // Este botón se encarga de la donación
        try {
        //Obtener la cantidad que el usuario quiere donar
        
        double montoDonado = Double.parseDouble(jTextField8.getText()); 

        //Verificar si tiene saldo suficiente para donar
        if (montoDonado > pantalla.saldoApp) {
            JOptionPane.showMessageDialog(this, "No tienes suficientes Auras para realizar esta donación.");
        } else if (montoDonado <= 0) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un monto válido mayor a 0.");
        } else {
            //RESTAR el monto del saldo actual
            pantalla.saldoApp -= montoDonado;

            //Actualizar la Base de Datos 
            actualizarSaldoBD db = new actualizarSaldoBD();
            db.actualizarSaldo(pantalla.usuarioIdentificado, pantalla.saldoApp);

            //Mostrar el mensaje
            JOptionPane.showMessageDialog(this, "¡Gracias! ¡Tus " + montoDonado + " Auras han sido donadas!");
            
            //Limpiar el campo y actualizar el label del saldo visualmente
            jTextField8.setText("");
            jLabel14.setText(String.valueOf(pantalla.saldoApp)); 
            
            
            //Conexión con la base de datos y guardamos el movimiento de donación
             Connection conexionReal = Conexion.conectar();

             String sql =
            "INSERT INTO Movimientos(id_usuario,monto,tipo_movimiento) " +
            "VALUES((SELECT id_usuario FROM Usuarios WHERE nombre=?),?,?)";

            PreparedStatement ps = conexionReal.prepareStatement(sql);

            ps.setString(1, pantalla.usuarioIdentificado);
            ps.setDouble(2, montoDonado);
            ps.setString(3, "Donacion");

            ps.executeUpdate();
            }

            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Error: Introduce un número válido para donar.");
            } catch (SQLException ex) {
                    Logger.getLogger(pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
       
        Jugada.seleccionarCaballo(jLabel18, "Rojo", Caballo);
        pantalla.caballoApostado = "Rojo";

    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        
        Jugada.seleccionarCaballo(jLabel19, "Verde", Caballo);
        pantalla.caballoApostado = "Verde";

    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        
        Jugada.seleccionarCaballo(jLabel20, "Amarillo", Caballo);
        pantalla.caballoApostado = "Amarillo";
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        
        Jugada.seleccionarCaballo(jLabel21, "Azul", Caballo);
        pantalla.caballoApostado = "Azul";

    }//GEN-LAST:event_jLabel21MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
       
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        //Este botón se encarga de realizar el juego
        //Validar que hay algo seleccionado
    if (pantalla.caballoApostado == null || pantalla.caballoApostado.equals("")) {
        JOptionPane.showMessageDialog(this, "Selecciona un caballo primero.");
        return;
    }

    try {
        double monto = Double.parseDouble(jTextField6.getText());
        
        if (monto <= 0 || monto > pantalla.saldoApp) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente o monto inválido.");
            return;
        }

        //REALIZAR LA APUESTA
        pantalla.montoApuesta = monto; // Guardamos en la variable estática
        pantalla.saldoApp -= monto;
        jLabel22.setText(pantalla.saldoApp + " Auras");

        //BLOQUEO DE SEGURIDAD 
        jButton13.setEnabled(false); 
        jTextField6.setEditable(false);
        
        //Actualizar Base de Datos
        actualizarSaldoBD db = new actualizarSaldoBD();
        db.actualizarSaldo(pantalla.usuarioIdentificado, pantalla.saldoApp);

        JOptionPane.showMessageDialog(this, "Apuesta confirmada por: " + pantalla.caballoApostado);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Escribe un número válido.");
    }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        
        Jugada.seleccionarCaballo(jLabel17, "Morado", Caballo);
        pantalla.caballoApostado = "Morado";
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        System.exit(0);       // Botón de cerrar sesión donde se cierra todo
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        jDialog5.setVisible(false);      
        jDialog4.setVisible(true);   
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
resetCarrera();

    jDialog1.setVisible(false);
    jDialog4.setVisible(true);           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
    resetCarrera();

    jDialog1.setVisible(false);
    jDialog5.setVisible(true);
    jLabel22.setText(String.valueOf(pantalla.saldoApp)); // Muestra el saldo actual al abrir// TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       //Botón del historial donde se llama a la clase historial
        
       jDialog7.setVisible(true);
       jDialog4.setVisible(false);

       historial.cargarMovimientos(jTable1, usuarioIdentificado);

       historial.cargarCarreras(jTable2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
 jDialog7.setVisible(false);    
 jDialog4.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed
 private void moverSalida() {
     
     //metodo que sirve para mover la salida y la meta en la carrera
     
     
    if (!carreraActiva) return;
    
    //movimiento de la salida a la velocidad elegida hacia la izquierda
    if (jLabel11.getX() + jLabel11.getWidth() > 0) {
        jLabel11.setLocation(jLabel11.getX() - velocidad, jLabel11.getY());
    }

    //movimiento de la meta a la misma velociad que la salida hacia la derecha
    //al llegar cualquiera de las progressbar a un punto en concreto
    if (jProgressBar1.getValue() >= 1260 ||
        jProgressBar2.getValue() >= 1260 ||
        jProgressBar3.getValue() >= 1260 ||
        jProgressBar4.getValue() >= 1260 ||
        jProgressBar5.getValue() >= 1260) {

        if (jLabel23.getX() > 0) {
            jLabel23.setLocation(jLabel23.getX() - velocidad, jLabel23.getY());
        } else {
            if (timerCarrera != null) timerCarrera.stop();
            carreraActiva = false;
            //activación de los botones de volver y volver al menú
            jLabel27.setEnabled(true);
            jLabel28.setEnabled(true);
            
            
        }
    }
}
    
    private void resetCarrera() {
        
        
    //metodo para parar la carrera
    carreraActiva = false;

    // parar timer
    if (timerCarrera != null) {
        timerCarrera.stop();
    }

    // reset posiciones
    jLabel11.setLocation(0, jLabel11.getY());
    jLabel23.setLocation(20000, jLabel23.getY());

    

    
     
    // desbloquear apuesta
    jButton13.setEnabled(true);
    jTextField6.setEditable(true);
}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JDialog jDialog6;
    private javax.swing.JDialog jDialog7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

void limpiar(){
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
}

}


