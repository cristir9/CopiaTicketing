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
    private String apellidos;
    private String nickname;
    private String password;
    private String email;
    private boolean is_Activo;
    private int idTipoUsuario;
    private int idUsuario;
    private String nombreTipoUsuario;

    public Usuario(int id, String nombre, String apellidos, String nickname, String password, String email, boolean is_Activo, int idTipoUsuario, int idUsuario, String nombreTipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.is_Activo = is_Activo;
        this.idTipoUsuario = idTipoUsuario;
        this.idUsuario = idUsuario;
        this.nombreTipoUsuario = nombreTipoUsuario;
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

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nickname=" + nickname + ", password=" + password + ", email=" + email + ", is_Activo=" + is_Activo + ", idTipoUsuario=" + idTipoUsuario + ", idUsuario=" + idUsuario + ", nombreTipoUsuario=" + nombreTipoUsuario + '}';
    }

 

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_Activo() {
        return is_Activo;
    }

    public void setIs_Activo(boolean is_Activo) {
        this.is_Activo = is_Activo;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }



   

 
}
