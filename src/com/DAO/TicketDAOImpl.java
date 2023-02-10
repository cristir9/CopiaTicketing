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
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public TicketDAOImpl() throws SQLException {
        this.URL = "jdbc:mysql://localhost:3306/TICKETING";
        this.con = DriverManager.getConnection(URL, "root", "root");
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
                + " ID_DISPOSITIVO, DESCRIPCION_INCIDENCIA, ID_PRIORIDAD, TITULO) VALUES (?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setDate(1, (Date) i.getFechaInicio());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setInt(3, 1);
            ps.setInt(4, i.getIdUsuario());
            ps.setInt(5, i.getIdTipoIncidencia());
            ps.setInt(6, i.getIdDispositivo());
            ps.setString(7, i.getDescripcion());
            ps.setInt(8, i.getIdPrioridad());
            ps.setString(9, i.getTitulo());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    @Override
    public void ModificarIncidencia() {
    }*/
    @Override
    public void cerrarIncidencia(int id) {
        ResultSet rs1 = null;
        int idEstado = 0;
        try {
            Statement st = this.con.createStatement();
            String sql1 = "SELECT * FROM ESTADO WHERE NOMBRE LIKE 'CERRAD_'";
            rs1 = st.executeQuery(sql1);

            while (rs1.next()) {
                idEstado = rs1.getInt(1);
                break;
            }

            String sql = "UPDATE INCIDENCIA SET FECHA_FIN = NOW(), ID_ESTADO=? where ID_INCIDENCIA = ?";
            try (PreparedStatement ps = this.con.prepareStatement(sql)) {
                ps.setInt(1, idEstado);
                ps.setInt(2, id);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs1 != null) {
                try {
                    rs1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public ArrayList<Incidencia> ObtenerIncidenciasPorIdUsuario(int id) {
        ArrayList<Incidencia> al = new ArrayList<Incidencia>();
        String sql = "SELECT I.ID_INCIDENCIA,I.TITULO,I.FECHA_INICIO,I.FECHA_PUBLICACION,I.FECHA_ULTIMA_MODIFICACION,I.FECHA_FIN, "
                + "I.ID_ESTADO,I.ID_USUARIO,I.ID_TIPOINCIDENCIA,I.ID_DISPOSITIVO,I.DESCRIPCION_INCIDENCIA,I.DESCRIPCION_SOLUCION, "
                + "I.ID_PRIORIDAD,ID_USUARIO_TECNICO,U.NOMBRE,U.APELLIDO,T.NOMBRE,D.TIPO,P.NOMBRE,E.NOMBRE,TIPO.NOMBRE "
                + "FROM INCIDENCIA I INNER JOIN USUARIO U ON I.ID_USUARIO = U.ID_USUARIO "
                + "INNER JOIN TIPO_USUARIO T ON U.ID_TIPOUSUARIO = T.ID_USUARIO  "
                + "INNER JOIN DISPOSITIVO D ON  I.ID_DISPOSITIVO=D.ID_DISPOSITIVO "
                + "INNER JOIN PRIORIDAD P ON I.ID_PRIORIDAD = P.ID_PRIORIDAD "
                + "INNER JOIN ESTADO E ON I.ID_ESTADO = E.ID_ESTADO "
                + "INNER JOIN TIPO_INCIDENCIA TIPO ON TIPO.ID_TIPOINCIDENCIA = I.ID_TIPOINCIDENCIA WHERE I.ID_USUARIO = ?";
        ResultSet rs = null;
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Incidencia i = new Incidencia(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5),
                        rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
                        rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14),
                        rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21));
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

    /*
    @Override
    public ArrayList<Incidencia> ObtenerAllIncidencias() {
        ArrayList al = new ArrayList();
        String sql = "SELECT * FROM INCIDENCIA";
        ResultSet rs = null;
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                Incidencia i = new Incidencia(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5),
                        rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
                        rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14));
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
     */
    @Override
    public ArrayList<Usuario> ObtenerUsuariosConTipo() {
        ArrayList<Usuario> ls = new ArrayList<Usuario>();
        ResultSet rs = null;
        String sql = "Select * from USUARIO u inner join TIPO_USUARIO t on u.ID_TIPOUSUARIO=t.ID_USUARIO";
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {

            rs = ps.executeQuery();
            Incidencia i;
            while (rs.next()) {
                u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getInt(8), rs.getInt(9), rs.getString(10));
                ls.add(u);

            }
            return ls;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public ArrayList<Incidencia> ObtenerAllIncidenciasConTodo() {
        ArrayList al = new ArrayList();
        String sql = "SELECT I.ID_INCIDENCIA,I.TITULO,I.FECHA_INICIO,I.FECHA_PUBLICACION,I.FECHA_ULTIMA_MODIFICACION,I.FECHA_FIN, "
                + "I.ID_ESTADO,I.ID_USUARIO,I.ID_TIPOINCIDENCIA,I.ID_DISPOSITIVO,I.DESCRIPCION_INCIDENCIA,I.DESCRIPCION_SOLUCION, "
                + "I.ID_PRIORIDAD,ID_USUARIO_TECNICO,U.NOMBRE,U.APELLIDO,T.NOMBRE,D.TIPO,P.NOMBRE,E.NOMBRE,TIPO.NOMBRE "
                + "FROM INCIDENCIA I INNER JOIN USUARIO U ON I.ID_USUARIO = U.ID_USUARIO "
                + "INNER JOIN TIPO_USUARIO T ON U.ID_TIPOUSUARIO = T.ID_USUARIO  "
                + "INNER JOIN DISPOSITIVO D ON  I.ID_DISPOSITIVO=D.ID_DISPOSITIVO "
                + "INNER JOIN PRIORIDAD P ON I.ID_PRIORIDAD = P.ID_PRIORIDAD "
                + "INNER JOIN ESTADO E ON I.ID_ESTADO = E.ID_ESTADO "
                + "INNER JOIN TIPO_INCIDENCIA TIPO ON TIPO.ID_TIPOINCIDENCIA = I.ID_TIPOINCIDENCIA;";
        ResultSet rs = null;

        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                Incidencia i = new Incidencia(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5),
                        rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
                        rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14),
                        rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21));
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

    @Override
    public Map<Integer, ArrayList<Object>> obtenerAtributos() {

        ResultSet rs1 = null;

        try {
            Map<Integer, ArrayList<Object>> lista = new HashMap<Integer, ArrayList<Object>>();

            String sql = "Select * from PRIORIDAD";
            Statement st = con.createStatement();

            rs1 = st.executeQuery(sql);
            lista.put(0, new ArrayList<Object>());
            while (rs1.next()) {
                Prioridad p = new Prioridad(rs1.getInt(1), rs1.getString(2));
                Object o = (Object) p;
                lista.get(0).add(o);
            }

            String sql2 = "Select * from DISPOSITIVO";
            rs1 = st.executeQuery(sql2);

            lista.put(1, new ArrayList<Object>());
            while (rs1.next()) {
                Dispositivo d = new Dispositivo(rs1.getInt(1), rs1.getString(2));
                Object o = (Object) d;
                lista.get(1).add(o);
            }

            String sql3 = "Select * from TIPO_INCIDENCIA";
            rs1 = st.executeQuery(sql3);

            lista.put(2, new ArrayList<Object>());
            while (rs1.next()) {
                Tipo_Incidencia t = new Tipo_Incidencia(rs1.getInt(1), rs1.getString(2));
                Object o = (Object) t;
                lista.get(2).add(o);
            }

            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs1 != null) {
                try {
                    rs1.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;

    }

    public ArrayList<Incidencia> filtroBusqueda(String searchParam) {
        ArrayList<Incidencia> lista = new ArrayList<Incidencia>();
        ResultSet rs = null;
        int contador=0;
        String sql = "SELECT I.ID_INCIDENCIA,I.TITULO,I.FECHA_INICIO,I.FECHA_PUBLICACION,I.FECHA_ULTIMA_MODIFICACION,I.FECHA_FIN, "
                + "I.ID_ESTADO,I.ID_USUARIO,I.ID_TIPOINCIDENCIA,I.ID_DISPOSITIVO,I.DESCRIPCION_INCIDENCIA,I.DESCRIPCION_SOLUCION, "
                + "I.ID_PRIORIDAD,ID_USUARIO_TECNICO,U.NOMBRE,U.APELLIDO,T.NOMBRE,D.TIPO,P.NOMBRE,E.NOMBRE,TIPO.NOMBRE "
                + "FROM INCIDENCIA I INNER JOIN USUARIO U ON I.ID_USUARIO = U.ID_USUARIO "
                + "INNER JOIN TIPO_USUARIO T ON U.ID_TIPOUSUARIO = T.ID_USUARIO  "
                + "INNER JOIN DISPOSITIVO D ON  I.ID_DISPOSITIVO=D.ID_DISPOSITIVO "
                + "INNER JOIN PRIORIDAD P ON I.ID_PRIORIDAD = P.ID_PRIORIDAD "
                + "INNER JOIN ESTADO E ON I.ID_ESTADO = E.ID_ESTADO "
                + "INNER JOIN TIPO_INCIDENCIA TIPO ON TIPO.ID_TIPOINCIDENCIA = I.ID_TIPOINCIDENCIA WHERE 1=1";
        if (searchParam != null && !(searchParam.isBlank())) {
            sql = sql + " AND I.ID_USUARIO = ?";
        }
        try (PreparedStatement ps = this.con.prepareStatement(sql)) {
            if (searchParam != null && !(searchParam.isBlank())) {
                contador++;
                 ps.setString(contador, searchParam);
            }
           

            rs = ps.executeQuery();

            while (rs.next()) {
                Incidencia i = new Incidencia(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5),
                        rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
                        rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14),
                        rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21));
                lista.add(i);

            }
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TicketDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }

 

}
