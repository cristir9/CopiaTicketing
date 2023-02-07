/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.io.Serializable;

/**
 *
 * @author dev
 */
public class Usuario implements Serializable{

    private int id;
    private String nombre;
    private String Apellidos;
    private String tipoUsuario;

    public Usuario(int id, String nombre, String Apellidos, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.Apellidos = Apellidos;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return nombre + " " + Apellidos + " || " + tipoUsuario;
    }
}
