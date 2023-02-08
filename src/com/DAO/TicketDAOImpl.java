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
import java.time.LocalDate;
import java.util.ArrayList;

public class TicketDAOImpl implements TicketDAO, AutoCloseable {

    private String URL;
    Connection con = null;
    Usuario u;

    static {
        try {
            Class.forName("org.mysql.jdbc.Driver");
        } catch (Exception e) {
        }
    }

    public TicketDAOImpl(String fileName, Usuario u) throws SQLException {
        this.URL = "jdbc:mysql://localhost:3306/" + fileName;
        this.con = DriverManager.getConnection(URL, "root", "root");
        this.u = u;
    }

    public TicketDAOImpl(Usuario u) throws SQLException {
        this.URL = "jdbc:mysql://localhost:3306/TICKETING";
        this.con = DriverManager.getConnection(URL, "root", "root");
        this.u = u;
    }

    @Override
    public void RegistrarIncidencia(Incidencia i) {
        String sql = "INSERT INTO INCIDENCIA (FECHA_INICIO, FECHA_PUBLICACION, ID_ESTADO, ID_USUARIO, ID_TIPOINCIDENCIA,"
                + " ID_DISPOSITIVO, DESCRIPCION_INCIDENCIA, ID_PRIORIDAD) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setDate(1, (Date) i.getFechaInicio());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setInt(3, 1);
            ps.setInt(4, i.getIdUsuarioAfectado());
            ps.setInt(5, i.getIdTipoIncidencia());
            ps.setInt(6, i.getIdDispositivo());
            ps.setString(7, i.getDescripcion());
            ps.setInt(8, i.getIdPrioridad());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ModificarIncidencia() {
    }

    @Override
    public void cerrarIncidencia(int id) {
        String sql = "UPDATE INCIDENCIA SET FECHA_FIN = NOW(), ID_ESTADO = 3 WHERE ID_INCIDENCIA = ?";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                Incidencia i = new Incidencia(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
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
    public ArrayList<Incidencia> ObtenerAllIncidencias() {
        ArrayList al = new ArrayList();
        String sql = "SELECT * FROM INCIDENCIA";
        ResultSet rs = null;
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                Incidencia i = new Incidencia(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
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
