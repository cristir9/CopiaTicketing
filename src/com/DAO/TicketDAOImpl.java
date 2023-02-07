/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketDAOImpl implements TicketDAO, AutoCloseable {

    private String URL;
    Connection con = null;

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
        }
    }

    public TicketDAOImpl(String fileName) throws SQLException {
        this.URL = "jdbc:mariadb://localhost:3306/" + fileName;
        this.con = DriverManager.getConnection(URL);
    }

    @Override
    public void RegistrarIncidencia(Incidencia i) {
        String sql = "INSERT INTO INCIDENCIA VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
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
    public ArrayList<Incidencia> ObtenerIncidenciasPorIdUsuario(int id) {
        ArrayList<Incidencia> al = new ArrayList<Incidencia>();
        String sql = "SELECT * FROM INCIDENCIA WHERE ID_USUARIO = ?";
        ResultSet rs = null;
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Incidencia i = new Incidencia(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
                        rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
                al.add(i);
            }
            return al;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
        }
    }

}
