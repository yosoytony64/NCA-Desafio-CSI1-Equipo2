/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caballos365;

/**
 *
 * @author Jorge
 */
public class Administrador extends Usuario {
    private String nivel_acceso;

    public Administrador(String nivel_acceso, int IDusuario, String nombre, String email, int edad) {
        super(IDusuario, nombre, email, edad);
        this.nivel_acceso = nivel_acceso;
    }

    public String getNivel_acceso() {
        return nivel_acceso;
    }

    public void setNivel_acceso(String nivel_acceso) {
        this.nivel_acceso = nivel_acceso;
    }
}
