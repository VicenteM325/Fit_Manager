package com.archivos.fitmanager.ui.entrenador;

import com.archivos.fitmanager.controller.AsistenciaController;
import com.archivos.fitmanager.controller.ClienteController;
import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.login.SessionManager;
import com.archivos.fitmanager.model.AsistenciaHistorial;
import com.archivos.fitmanager.model.Cliente;
import com.archivos.fitmanager.ui.recepcion.Asistencias;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicente
 */
public class ConsultaRutinas extends javax.swing.JPanel {

    AsistenciaController asistenciaController;
    ClienteController clienteController;

    /**
     * Creates new form ConsultaRutinas
     */
    public ConsultaRutinas() {
        initComponents();
        try {
            Connection conn = DBConfig.getConnection();
            asistenciaController = new AsistenciaController();
            clienteController = new ClienteController(conn);
             cargarClientesEntrenador();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error inicializando controladores: " + e.getMessage());
        }
        jTableHistorial.setVisible(false);
        jComboBoxClientesId.setVisible(false);
        jLabelCoincidencias.setVisible(false);
    }

    private void mostrarHistorialEntrenador() {
        try {
            int idEntrenador = SessionManager.getIdUsuario();
            List<AsistenciaHistorial> historial = asistenciaController.historialPorEntrenador(idEntrenador);

            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[]{"ID Asistencia", "Cliente", "Fecha", "Sucursal"}, 0);

            jTableHistorial.setModel(modelo);

            for (AsistenciaHistorial h : historial) {
                modelo.addRow(new Object[]{
                    h.getIdAsistencia(),
                    h.getNombreCliente(),
                    h.getFechaHora(),
                    h.getSucursal()
                });
            }
            jTableHistorial.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error cargando historial:\n" + ex.getMessage());
        }
    }

    private void cargarHistorialAsistencias(int idCliente) {
        try {
            List<AsistenciaHistorial> historial = asistenciaController.historialPorCliente(idCliente);

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"ID Asistencia", "Cliente", "Fecha", "Sucursal"}, 0);

            for (AsistenciaHistorial a : historial) {
                model.addRow(new Object[]{
                    a.getIdAsistencia(),
                    a.getNombreCliente(),
                    a.getFechaHora(),
                    a.getSucursal()
                });
            }

            jTableHistorial.setModel(model);
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Error cargando historial:\n" + e.getMessage(),
                    "Error",
                    javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void cargarClientesEntrenador() {
    try {
        int idEntrenador = SessionManager.getIdUsuario();
        List<Cliente> clientes = clienteController.obtenerClientesPorEntrenador(idEntrenador);

        jComboBoxClientesId.removeAllItems();
        for (Cliente c : clientes) {
            jComboBoxClientesId.addItem(c.getIdCliente() + " - " + c.getNombre());
        }

        jComboBoxClientesId.setVisible(true);
        jLabelCoincidencias.setVisible(true);

    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Error cargando clientes:\n" + e.getMessage(),
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabelTravel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorial = new javax.swing.JTable();
        btnMostrarHistorial = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jComboBoxClientesId = new javax.swing.JComboBox<>();
        jLabelCoincidencias = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        jLabelNombreEjercicios1 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnListarClientes = new javax.swing.JButton();

        setBackground(new java.awt.Color(33, 45, 62));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("_________________________");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 360, 30));

        jLabelTravel2.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabelTravel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTravel2.setText("CONSULTA ENTRENADOR");
        add(jLabelTravel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 320, 60));

        jTableHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableHistorial);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 600, 340));

        btnMostrarHistorial.setBackground(new java.awt.Color(73, 181, 172));
        btnMostrarHistorial.setFont(new java.awt.Font("Gotham Extra Light", 0, 24)); // NOI18N
        btnMostrarHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarHistorial.setText("Historial Completo Asistencias");
        btnMostrarHistorial.setBorderPainted(false);
        btnMostrarHistorial.setContentAreaFilled(false);
        btnMostrarHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrarHistorial.setFocusPainted(false);
        btnMostrarHistorial.setFocusable(false);
        btnMostrarHistorial.setRequestFocusEnabled(false);
        btnMostrarHistorial.setVerifyInputWhenFocusTarget(false);
        btnMostrarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarHistorialActionPerformed(evt);
            }
        });
        add(btnMostrarHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 370, 60));

        jSeparator3.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator3.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 60, 20));

        jComboBoxClientesId.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jComboBoxClientesId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxClientesId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClientesIdActionPerformed(evt);
            }
        });
        add(jComboBoxClientesId, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 290, -1));

        jLabelCoincidencias.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelCoincidencias.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCoincidencias.setText("Clientes");
        add(jLabelCoincidencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 100, 30));

        txtIdUser.setBackground(new java.awt.Color(33, 45, 62));
        txtIdUser.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        txtIdUser.setForeground(new java.awt.Color(195, 218, 227));
        txtIdUser.setBorder(null);
        txtIdUser.setCaretColor(new java.awt.Color(73, 181, 172));
        txtIdUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUserActionPerformed(evt);
            }
        });
        txtIdUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdUserKeyReleased(evt);
            }
        });
        add(txtIdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 70, 50));

        jLabelNombreEjercicios1.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelNombreEjercicios1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreEjercicios1.setText("Id");
        add(jLabelNombreEjercicios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 30, 30));

        btnLimpiar.setBackground(new java.awt.Color(73, 181, 172));
        btnLimpiar.setFont(new java.awt.Font("Gotham Extra Light", 0, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setFocusable(false);
        btnLimpiar.setRequestFocusEnabled(false);
        btnLimpiar.setVerifyInputWhenFocusTarget(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 240, 60));

        btnListarClientes.setBackground(new java.awt.Color(73, 181, 172));
        btnListarClientes.setFont(new java.awt.Font("Gotham Extra Light", 0, 24)); // NOI18N
        btnListarClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnListarClientes.setText("Listar Clientes Asociados");
        btnListarClientes.setBorderPainted(false);
        btnListarClientes.setContentAreaFilled(false);
        btnListarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListarClientes.setFocusPainted(false);
        btnListarClientes.setFocusable(false);
        btnListarClientes.setRequestFocusEnabled(false);
        btnListarClientes.setVerifyInputWhenFocusTarget(false);
        btnListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarClientesActionPerformed(evt);
            }
        });
        add(btnListarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 310, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarHistorialActionPerformed
         cargarClientesEntrenador();
         mostrarHistorialEntrenador();
         jTableHistorial.setVisible(true);
        jComboBoxClientesId.setVisible(true);
        jLabelCoincidencias.setVisible(true);
    }//GEN-LAST:event_btnMostrarHistorialActionPerformed

    private void jComboBoxClientesIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClientesIdActionPerformed
        if (jComboBoxClientesId.getSelectedItem() != null) {
        String seleccionado = (String) jComboBoxClientesId.getSelectedItem();
        int idCliente = Integer.parseInt(seleccionado.split(" - ")[0]);
        txtIdUser.setText(String.valueOf(idCliente));

        // cargar historial
        cargarHistorialAsistencias(idCliente);
    }
    }//GEN-LAST:event_jComboBoxClientesIdActionPerformed

    private void txtIdUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUserActionPerformed

    private void txtIdUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdUserKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUserKeyReleased

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // Limpiar los campos de texto
        txtIdUser.setText("");

        // Vaciar el combo y ocultarlo
        jComboBoxClientesId.removeAllItems();
        jComboBoxClientesId.setVisible(false);
        jLabelCoincidencias.setVisible(false);

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarClientesActionPerformed
        try {
            int idEntrenador = SessionManager.getIdUsuario();
            List<Cliente> clientes = clienteController.obtenerClientesPorEntrenador(idEntrenador);

            DefaultTableModel modelo = new DefaultTableModel(
                    new Object[]{"ID Cliente", "Nombre", "Apellido", "Teléfono"}, 0);

            for (Cliente c : clientes) {
                modelo.addRow(new Object[]{
                    c.getIdCliente(),
                    c.getNombre(),
                    c.getApellido(),
                    c.getTelefono()
                });
            }

            jTableHistorial.setModel(modelo);
            jTableHistorial.setVisible(true);

        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error cargando clientes: " + e.getMessage(),
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnListarClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListarClientes;
    private javax.swing.JButton btnMostrarHistorial;
    private javax.swing.JComboBox<String> jComboBoxClientesId;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCoincidencias;
    private javax.swing.JLabel jLabelNombreEjercicios1;
    private javax.swing.JLabel jLabelTravel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableHistorial;
    private javax.swing.JTextField txtIdUser;
    // End of variables declaration//GEN-END:variables
}
