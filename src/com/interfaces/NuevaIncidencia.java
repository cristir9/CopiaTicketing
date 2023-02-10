/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.interfaces;

import com.DAO.Dispositivo;
import com.DAO.Incidencia;
import com.DAO.Prioridad;
import com.DAO.TicketDAOImpl;
import com.DAO.Tipo_Incidencia;
import com.DAO.Usuario;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author dev
 */
public class NuevaIncidencia extends javax.swing.JFrame {

    private Usuario u;
    private Map<Integer, ArrayList<Object>> listaAtributos;

    /**
     * Creates new form Incidencia
     */
    public NuevaIncidencia() {
        initComponents();
        this.setTitle("NUEVA INCIDENCIA");
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public NuevaIncidencia(Usuario u) {
        initComponents();
        this.setTitle("NUEVA INCIDENCIA");
        this.u = u;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.jTextFieldNombre.setText(u.getNombre() + " " + u.getApellidos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanel = new javax.swing.JDesktopPane();
        jButtonAyuda = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComentarios = new javax.swing.JTextArea();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabelFechaIncidencia = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelComentarios = new javax.swing.JLabel();
        jButtonEnviar = new javax.swing.JButton();
        jLabelPrioridad = new javax.swing.JLabel();
        jLabelTipoIncidencia = new javax.swing.JLabel();
        jLabelDispositivo = new javax.swing.JLabel();
        DesplegableTipo = new javax.swing.JComboBox<>();
        DesplegablePrioridad = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        DesplegableDispositivo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButtonAyuda.setText("Ayuda");
        jButtonAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAyudaActionPerformed(evt);
            }
        });

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTitulo.setText("Título:");

        jTextAreaComentarios.setColumns(20);
        jTextAreaComentarios.setRows(5);
        jScrollPane1.setViewportView(jTextAreaComentarios);

        jTextFieldTitulo.setToolTipText("Indique sus apellidos.");

        jLabelFechaIncidencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFechaIncidencia.setText("Fecha incidencia:");

        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNombre.setText("Nombre:");

        jTextFieldNombre.setToolTipText("Indique su nombre");
        jTextFieldNombre.setFocusable(false);

        jLabelComentarios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelComentarios.setText("Comentarios:");

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jLabelPrioridad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPrioridad.setText("Prioridad:");

        jLabelTipoIncidencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTipoIncidencia.setText("Tipo:");

        jLabelDispositivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDispositivo.setText("Dispositivo:");

        DesplegableTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesplegableTipoActionPerformed(evt);
            }
        });

        jDesktopPanel.setLayer(jButtonAyuda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jTextFieldTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelFechaIncidencia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jTextFieldNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelComentarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jButtonEnviar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelPrioridad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelTipoIncidencia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelDispositivo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(DesplegableTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(DesplegablePrioridad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jDateChooser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(DesplegableDispositivo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre))
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTitulo))
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DesplegableDispositivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jButtonAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelFechaIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelTipoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DesplegableTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DesplegablePrioridad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldTitulo)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTipoIncidencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DesplegableTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DesplegableDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DesplegablePrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnviar)
                    .addComponent(jButtonAyuda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAyudaActionPerformed

    }//GEN-LAST:event_jButtonAyudaActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        try (TicketDAOImpl tdi = new TicketDAOImpl(this.u);) {
            Incidencia i = new Incidencia();
            i.setTitulo(this.jTextFieldTitulo.getText().toString());
            i.setIdUsuario(u.getId());
            i.setDescripcion(this.jTextAreaComentarios.getText());
            i.setFechaInicio(new java.sql.Date(this.jDateChooser.getDate().getTime()));
            i.setIdTipoIncidencia(Integer.parseInt(this.DesplegableTipo.getSelectedItem().toString().substring(0, 1)));
            i.setIdPrioridad(Integer.parseInt(this.DesplegablePrioridad.getSelectedItem().toString().substring(0, 1)));
            i.setIdDispositivo(Integer.parseInt(this.DesplegablePrioridad.getSelectedItem().toString().substring(0, 1)));
            tdi.RegistrarIncidencia(i);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(NuevaIncidencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
      
       
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          if (u.getNombreTipoUsuario().equalsIgnoreCase("Usuario")) {
            User user = new User(u);  
            user.setVisible(true);
        } else if (u.getNombreTipoUsuario().equalsIgnoreCase("Administrador")) {
            Admin a = new Admin(u);
            a.setVisible(true);
        } else if (u.getNombreTipoUsuario().equalsIgnoreCase("Gestor")) {
            Gestor g = new Gestor(u);
            g.setVisible(true);
        } else if (u.getNombreTipoUsuario().equalsIgnoreCase("tecnico")) {
            Tecnico g = new Tecnico(u);
            g.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated

    }//GEN-LAST:event_formWindowDeactivated

    private void DesplegableTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesplegableTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DesplegableTipoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        try (TicketDAOImpl gestor = new TicketDAOImpl()) {
            this.listaAtributos = gestor.obtenerAtributos();
            for (Object e : listaAtributos.get(0)) {
                Prioridad p = (Prioridad) e;
                this.DesplegablePrioridad.addItem(p.getId() + " " + p.getNombre());
            }
            for (Object e : listaAtributos.get(1)) {
                Dispositivo d = (Dispositivo) e;
                this.DesplegableDispositivo.addItem(d.getId() + " " + d.getNombre());
            }
            for (Object e : listaAtributos.get(2)) {
                Tipo_Incidencia t = (Tipo_Incidencia) e;

                this.DesplegableTipo.addItem(t.getId() + " " + t.getNombre());
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:


    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(NuevaIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaIncidencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaIncidencia().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DesplegableDispositivo;
    private javax.swing.JComboBox<String> DesplegablePrioridad;
    private javax.swing.JComboBox<String> DesplegableTipo;
    private javax.swing.JButton jButtonAyuda;
    private javax.swing.JButton jButtonEnviar;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JLabel jLabelComentarios;
    private javax.swing.JLabel jLabelDispositivo;
    private javax.swing.JLabel jLabelFechaIncidencia;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrioridad;
    private javax.swing.JLabel jLabelTipoIncidencia;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaComentarios;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables

}
