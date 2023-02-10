/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author dev
 */
public class Incidencia implements Serializable {

    private int id;
    private String titulo;
    private Date fechaInicio;
    private Date fechaPublicacion;
    private Date fechaUltimaModificacion;
    private Date fechaFin;
    private int idEstado;
    private int idUsuario;
    private int idTipoIncidencia;  
    private int idDispositivo;
    private String descripcion;
    private String solucion;
    private int idPrioridad;
    private int idUsuarioTecnico;
    private String nombreUsuario;
    private String Apellido;
    private String rol;
    private String nombreDispositivo;
    private String nombrePrioridad;
    private String nombreEstado;
    private String nombreTipoIncidencia;

    public Incidencia(int id, String titulo, Date fechaInicio, Date fechaPublicacion, Date fechaUltimaModificacion, Date fechaFin, int idEstado, int idUsuario, int idTipoIncidencia, int idDispositivo, String descripcion, String solucion, int idPrioridad, int idUsuarioTecnico, String nombreUsuario, String Apellido, String rol, String nombreDispositivo, String nombrePrioridad, String nombreEstado, String nombreTipoIncidencia) {
        this.id = id;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.fechaFin = fechaFin;
        this.idEstado = idEstado;
        this.idUsuario = idUsuario;
        this.idTipoIncidencia = idTipoIncidencia;
        this.idDispositivo = idDispositivo;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.idPrioridad = idPrioridad;
        this.idUsuarioTecnico = idUsuarioTecnico;
        this.nombreUsuario = nombreUsuario;
        this.Apellido = Apellido;
        this.rol = rol;
        this.nombreDispositivo = nombreDispositivo;
        this.nombrePrioridad = nombrePrioridad;
        this.nombreEstado = nombreEstado;
        this.nombreTipoIncidencia = nombreTipoIncidencia;
    }

    public Incidencia() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoIncidencia() {
        return idTipoIncidencia;
    }

    public void setIdTipoIncidencia(int idTipoIncidencia) {
        this.idTipoIncidencia = idTipoIncidencia;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public int getIdUsuarioTecnico() {
        return idUsuarioTecnico;
    }

    public void setIdUsuarioTecnico(int idUsuarioTecnico) {
        this.idUsuarioTecnico = idUsuarioTecnico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getNombreTipoIncidencia() {
        return nombreTipoIncidencia;
    }

    public void setNombreTipoIncidencia(String nombreTipoIncidencia) {
        this.nombreTipoIncidencia = nombreTipoIncidencia;
    }
    
    

}
