/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author dev
 */
public interface TicketDAO {
    
    public void RegistrarIncidencia(Incidencia i);
    //public void ModificarIncidencia();
    //public ArrayList<Incidencia> ObtenerIncidenciasPorIdUsuario(int id);
    public ArrayList<Incidencia> filtroBusqueda(String searchParam);
    public void cerrarIncidencia(int id);
    //public ArrayList<Incidencia> ObtenerAllIncidencias();
    public ArrayList<Usuario>ObtenerUsuariosConTipo();
    public ArrayList<Incidencia> ObtenerIncidenciasPorIdUsuario(int id);
    public ArrayList<Incidencia> ObtenerAllIncidenciasConTodo();
    public Map<Integer,ArrayList<Object>> obtenerAtributos();
}
