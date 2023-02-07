/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TicketDAOImpl implements TicketDAO, AutoCloseable {
    
    private String URL;
    Connection con = null;
    
    
    static{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
        }
    }

    public TicketDAOImpl(String fileName) throws SQLException {
       this.URL= "jdbc:mariadb://localhost:3306/"+fileName;
       this.con= DriverManager.getConnection(URL);
    }

    
    
    @Override
    public void RegistrarIncidencia(Incidencia i) {
       String sql= "INSERT INTO INCIDENCIA VALUES (?,?,?,?,?,?,?,?,?,?,?)";
       
        try (PreparedStatement ps = this.con.prepareStatement(sql)){
            ps.setInt(1, i.getId());
            ps.setDate(2, (Date) i.getFechaInicio());
            ps.setDate(3, (Date) i.getFechaFinal());
            ps.setInt(4, i.getIdEstado());
            ps.setInt(5, i.getIdTipoIncidencia());
            ps.setInt(6, i.getIdDispositivo());
            ps.setString(7, i.getDescripcion());
            ps.setString(8, i.getSolucion());
            ps.setInt(9, i.getIdUsuarioTecnico());
            ps.setInt(10, i.getIdPrioridad());
            ps.setInt(11, i.getIdUsuarioAfectado());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ModificarIncidencia() {
    }

    @Override
    public void close() throws Exception {
        try {
            if (con!=null) {
                con.close();
            }
        } catch (Exception e) {
        }
    }
    
}
