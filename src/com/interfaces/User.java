/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.interfaces;

import com.DAO.Incidencia;
import com.DAO.TicketDAOImpl;
import com.DAO.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dev
 */
public class User extends javax.swing.JFrame {

    public Usuario u;

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        this.setTitle("USER");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Usuario u = new Usuario(9, "user", "user", "9");
        this.u = u;
    }

    public User(Usuario u) {
        initComponents();
        this.setTitle("USER");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.u = u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableIncidencias = new javax.swing.JTable();
        jButtonNuevaIncidencia = new javax.swing.JButton();
        jButtonCerrarIncidencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTableIncidencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado", "Título", "Fecha apertura", "Ultima modificacion", "Fecha cierre", "Comentarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableIncidencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIncidenciasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableIncidencias);
        if (jTableIncidencias.getColumnModel().getColumnCount() > 0) {
            jTableIncidencias.getColumnModel().getColumn(0).setResizable(false);
            jTableIncidencias.getColumnModel().getColumn(1).setResizable(false);
            jTableIncidencias.getColumnModel().getColumn(2).setResizable(false);
            jTableIncidencias.getColumnModel().getColumn(3).setResizable(false);
            jTableIncidencias.getColumnModel().getColumn(4).setResizable(false);
            jTableIncidencias.getColumnModel().getColumn(5).setResizable(false);
            jTableIncidencias.getColumnModel().getColumn(6).setResizable(false);
        }

        jButtonNuevaIncidencia.setText("Nueva incidencia");
        jButtonNuevaIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaIncidenciaActionPerformed(evt);
            }
        });

        jButtonCerrarIncidencia.setText("Cerrar incidencia");
        jButtonCerrarIncidencia.setEnabled(false);
        jButtonCerrarIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarIncidenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNuevaIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCerrarIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevaIncidencia)
                    .addComponent(jButtonCerrarIncidencia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevaIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaIncidenciaActionPerformed
        NuevaIncidencia ni = new NuevaIncidencia(this.u);
        this.dispose();
        ni.setVisible(true);
        ni.requestFocus();
    }//GEN-LAST:event_jButtonNuevaIncidenciaActionPerformed

    private void jButtonCerrarIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarIncidenciaActionPerformed
        int idIncidencia = -1;
        try (TicketDAOImpl tdi = new TicketDAOImpl(this.u)) {
            DefaultTableModel dtm = (DefaultTableModel) this.jTableIncidencias.getModel();
            if (this.jTableIncidencias.getSelectedRow() != -1) {
                idIncidencia = (Integer) dtm.getValueAt(this.jTableIncidencias.getSelectedRow(), 0);
            }
            if (JOptionPane.showConfirmDialog(null, "¿De verdad deseas cerrar la incidencia?\nEsta acción es irreversible.", "OJOCUIDAO",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // yes option
                if (idIncidencia != -1) {
                    tdi.cerrarIncidencia(idIncidencia);
                    this.rellenarTablaIncidencias();
                }
            } else {
                // no option
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCerrarIncidenciaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.rellenarTablaIncidencias();
    }//GEN-LAST:event_formWindowActivated

    private void jTableIncidenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIncidenciasMouseClicked
        this.jButtonCerrarIncidencia.setEnabled(true);
    }//GEN-LAST:event_jTableIncidenciasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    public void rellenarTablaIncidencias() {
        try (TicketDAOImpl tdi = new TicketDAOImpl(this.u)) {
            String estado = "";
            this.u.setId(1);
            ArrayList<Incidencia> al = tdi.ObtenerIncidenciasPorIdUsuario(this.u.getId());
            DefaultTableModel dtm = (DefaultTableModel) this.jTableIncidencias.getModel();
            dtm.setNumRows(0);
            for (Incidencia i : al) {
                if (i.getIdEstado() == 1) {
                    estado = "Abierta";
                } else if (i.getIdEstado() == 2) {
                    estado = "En trámite";
                } else if (i.getIdEstado() == 3) {
                    estado = "Cerrada";
                } else if (i.getIdEstado() == 4) {
                    estado = "resuelta";
                }
                Object[] array = {i.getId(), estado, i.getTitulo(), i.getFechaInicio(), i.getFechaFinal(), i.getFechaFinal(), i.getDescripcion()};
                System.out.println(i);
                dtm.addRow(array);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    
//    tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//public void valueChanged(ListSelectionEvent event) {
//eliminarButton.setVisible(true);
//modificarButton.setVisible(true);
//
//}
//
//});
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarIncidencia;
    private javax.swing.JButton jButtonNuevaIncidencia;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableIncidencias;
    // End of variables declaration//GEN-END:variables
}
