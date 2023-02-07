/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.util.ArrayList;

/**
 *
 * @author dev
 */
public interface TicketDAO {
    
    public void RegistrarIncidencia(Incidencia i);
    public void ModificarIncidencia();
    public ArrayList<Incidencia> ObtenerIncidenciasPorIdUsuario(int id);
}
