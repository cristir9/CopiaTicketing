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
    private Date fechaInicio;
    private Date fechaFinal;
    private int idEstado;
    private int idTipoIncidencia;
    private int idDispositivo;
    private String descripcion;
    private String solucion;
    private int idUsuarioTecnico;
    private int idPrioridad;
    private int idUsuarioAfectado;

    public Incidencia(int id, Date fechaInicio, Date fechaFinal, int idEstado, int idTipoIncidencia, int idDispositivo, String descripcion, String solucion, int idUsuarioTecnico, int idPrioridad, int idUsuarioAfectado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.idEstado = idEstado;
        this.idTipoIncidencia = idTipoIncidencia;
        this.idDispositivo = idDispositivo;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.idUsuarioTecnico = idUsuarioTecnico;
        this.idPrioridad = idPrioridad;
        this.idUsuarioAfectado = idUsuarioAfectado;
    }

    public int getIdUsuarioAfectado() {
        return idUsuarioAfectado;
    }

    public void setIdUsuarioAfectado(int idUsuarioAfectado) {
        this.idUsuarioAfectado = idUsuarioAfectado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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

    public int getIdUsuarioTecnico() {
        return idUsuarioTecnico;
    }

    public void setIdUsuarioTecnico(int idUsuarioTecnico) {
        this.idUsuarioTecnico = idUsuarioTecnico;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    @Override
    public String toString() {
        return "Incidencia id => " + id + ": fechaInicio= " + fechaInicio + ", fechaFinal= " + fechaFinal + ", idEstado= " + idEstado + ", idTipoIncidencia= " + idTipoIncidencia + ", idDispositivo= " + idDispositivo + ", descripcion= " + descripcion + ", solucion= " + solucion + ", idUsuarioTecnico= " + idUsuarioTecnico + ", idPrioridad= " + idPrioridad + ", idUsuarioAfectado= " + idUsuarioAfectado;
    }
    
    
    
    
    
}
