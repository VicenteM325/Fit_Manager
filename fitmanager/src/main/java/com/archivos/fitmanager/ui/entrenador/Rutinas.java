package com.archivos.fitmanager.ui.entrenador;

import com.archivos.fitmanager.controller.RutinaController;
import com.archivos.fitmanager.dao.ClienteDAO;
import com.archivos.fitmanager.dao.EjercicioDAO;
import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.login.SessionManager;
import com.archivos.fitmanager.model.Cliente;
import com.archivos.fitmanager.model.Ejercicio;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class Rutinas extends javax.swing.JPanel {

    private Map<String, Integer> mapaClientes = new HashMap<>();

    /**
     * Creates new form Rutinas
     */
    public Rutinas() {
        initComponents();
        jListEjercicios.setModel(new DefaultListModel<>());      
        jListEjerciciosAgregados.setModel(new DefaultListModel<>());

        cargarClientes();
        cargarEjercicios();
    }

    private void cargarClientes() {
        try (Connection conn = DBConfig.getConnection()) {
            ClienteDAO clienteDAO = new ClienteDAO(conn);
            int idEntrenador = SessionManager.getIdUsuario();
            List<Cliente> clientes = clienteDAO.obtenerClientesPorEntrenador(idEntrenador);

            jComboBoxCliente.removeAllItems();
            jComboBoxCliente.addItem("Seleccione un cliente");
            mapaClientes.clear();

            for (Cliente c : clientes) {
                String item = c.getNombre() + " " + c.getApellido();
                System.out.println("Cargando cliente: " + item + " con ID " + c.getIdCliente());
                jComboBoxCliente.addItem(item);
                mapaClientes.put(item, c.getIdCliente());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error cargando clientes: " + e.getMessage());
        }
    }

    private void cargarEjercicios() {
        try (Connection conn = DBConfig.getConnection()) {
            EjercicioDAO ejercicioDAO = new EjercicioDAO(conn);
            List<Ejercicio> ejercicios = ejercicioDAO.obtenerEjercicios();

            DefaultListModel<String> modelo = (DefaultListModel<String>) jListEjercicios.getModel();
            modelo.clear();
            for (Ejercicio e : ejercicios) {
                modelo.addElement(e.getNombre());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error cargando ejercicios: " + e.getMessage());
        }
    }

    public int obtenerIdEjercicioPorNombre(String nombre) throws SQLException {
        try (Connection conn = DBConfig.getConnection()) {
            EjercicioDAO ejercicioDAO = new EjercicioDAO(conn);
            return ejercicioDAO.obtenerIdPorNombre(nombre);
        }
    }

    private void limpiarFormulario() {
        txtNombreRutina.setText("");

        if (jComboBoxCliente.getItemCount() > 0) {
            jComboBoxCliente.setSelectedIndex(0);
        }

        jListEjercicios.clearSelection();
        txtNombreRutina.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTravel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelNombreCliente = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        txtNombreRutina = new javax.swing.JTextField();
        jLabelNombreRutina = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelEjercicios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEjercicios = new javax.swing.JList<>();
        btnAgregarEjercicio = new javax.swing.JButton();
        btnQuitarEjercicio = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCrearRutina = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListEjerciciosAgregados = new javax.swing.JList<>();
        jLabelRutina = new javax.swing.JLabel();

        setBackground(new java.awt.Color(33, 45, 62));
        setMaximumSize(new java.awt.Dimension(1040, 600));
        setMinimumSize(new java.awt.Dimension(1040, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTravel2.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabelTravel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTravel2.setText("RUTINAS");
        add(jLabelTravel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 170, 60));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("____________");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, 30));

        jLabelNombreCliente.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreCliente.setText("Cliente");
        add(jLabelNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 90, 30));

        jComboBoxCliente.setBackground(new java.awt.Color(33, 45, 62));
        jComboBoxCliente.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jComboBoxCliente.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxClienteActionPerformed(evt);
            }
        });
        add(jComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 300, 40));

        txtNombreRutina.setBackground(new java.awt.Color(33, 45, 62));
        txtNombreRutina.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        txtNombreRutina.setForeground(new java.awt.Color(195, 218, 227));
        txtNombreRutina.setBorder(null);
        txtNombreRutina.setCaretColor(new java.awt.Color(73, 181, 172));
        txtNombreRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRutinaActionPerformed(evt);
            }
        });
        txtNombreRutina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreRutinaKeyReleased(evt);
            }
        });
        add(txtNombreRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 300, 50));

        jLabelNombreRutina.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelNombreRutina.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreRutina.setText("Nombre Rutina");
        add(jLabelNombreRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 160, 30));

        jSeparator3.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator3.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 310, 10));

        jLabelEjercicios.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelEjercicios.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEjercicios.setText("Ejercicios");
        add(jLabelEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 120, 30));

        jListEjercicios.setBackground(new java.awt.Color(33, 45, 62));
        jListEjercicios.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        jListEjercicios.setForeground(new java.awt.Color(255, 255, 255));
        jListEjercicios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListEjercicios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 300, 300));

        btnAgregarEjercicio.setBackground(new java.awt.Color(73, 181, 172));
        btnAgregarEjercicio.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnAgregarEjercicio.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarEjercicio.setText("Agregar");
        btnAgregarEjercicio.setBorderPainted(false);
        btnAgregarEjercicio.setContentAreaFilled(false);
        btnAgregarEjercicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarEjercicio.setFocusPainted(false);
        btnAgregarEjercicio.setFocusable(false);
        btnAgregarEjercicio.setRequestFocusEnabled(false);
        btnAgregarEjercicio.setVerifyInputWhenFocusTarget(false);
        btnAgregarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEjercicioActionPerformed(evt);
            }
        });
        add(btnAgregarEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 120, 60));

        btnQuitarEjercicio.setBackground(new java.awt.Color(73, 181, 172));
        btnQuitarEjercicio.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnQuitarEjercicio.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarEjercicio.setText("Quitar");
        btnQuitarEjercicio.setBorderPainted(false);
        btnQuitarEjercicio.setContentAreaFilled(false);
        btnQuitarEjercicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarEjercicio.setFocusPainted(false);
        btnQuitarEjercicio.setFocusable(false);
        btnQuitarEjercicio.setRequestFocusEnabled(false);
        btnQuitarEjercicio.setVerifyInputWhenFocusTarget(false);
        btnQuitarEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarEjercicioActionPerformed(evt);
            }
        });
        add(btnQuitarEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 120, 60));

        btnLimpiar.setBackground(new java.awt.Color(73, 181, 172));
        btnLimpiar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
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
        add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 120, 60));

        btnCrearRutina.setBackground(new java.awt.Color(73, 181, 172));
        btnCrearRutina.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnCrearRutina.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearRutina.setText("Crear Rutina");
        btnCrearRutina.setBorderPainted(false);
        btnCrearRutina.setContentAreaFilled(false);
        btnCrearRutina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearRutina.setFocusPainted(false);
        btnCrearRutina.setFocusable(false);
        btnCrearRutina.setRequestFocusEnabled(false);
        btnCrearRutina.setVerifyInputWhenFocusTarget(false);
        btnCrearRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRutinaActionPerformed(evt);
            }
        });
        add(btnCrearRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 150, 60));

        jListEjerciciosAgregados.setBackground(new java.awt.Color(33, 45, 62));
        jListEjerciciosAgregados.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        jListEjerciciosAgregados.setForeground(new java.awt.Color(255, 255, 255));
        jListEjerciciosAgregados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListEjerciciosAgregados);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 310, 300));

        jLabelRutina.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelRutina.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRutina.setText("Rutina");
        add(jLabelRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 80, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxClienteActionPerformed

    }//GEN-LAST:event_jComboBoxClienteActionPerformed

    private void txtNombreRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRutinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreRutinaActionPerformed

    private void txtNombreRutinaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreRutinaKeyReleased

    }//GEN-LAST:event_txtNombreRutinaKeyReleased

    private void btnAgregarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEjercicioActionPerformed
        List<String> seleccionados = jListEjercicios.getSelectedValuesList();
        DefaultListModel<String> modeloAgregados = (DefaultListModel<String>) jListEjerciciosAgregados.getModel();

        for (String ejercicio : seleccionados) {
            if (!modeloAgregados.contains(ejercicio)) {
                modeloAgregados.addElement(ejercicio);
            }
        }
    }//GEN-LAST:event_btnAgregarEjercicioActionPerformed

    private void btnQuitarEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarEjercicioActionPerformed
        List<String> seleccionados = jListEjerciciosAgregados.getSelectedValuesList();
        DefaultListModel<String> modeloAgregados = (DefaultListModel<String>) jListEjerciciosAgregados.getModel();

        for (String ejercicio : seleccionados) {
            modeloAgregados.removeElement(ejercicio);
        }
    }//GEN-LAST:event_btnQuitarEjercicioActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
          limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCrearRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRutinaActionPerformed
        try {
            // Obtener el índice del cliente seleccionado
            String seleccionado = (String) jComboBoxCliente.getSelectedItem();
            if (seleccionado == null || seleccionado.equals("Seleccione un cliente")) {
                JOptionPane.showMessageDialog(this, "Seleccione un cliente válido.");
                return;
            }

            Integer idCliente = mapaClientes.get(seleccionado);
            if (idCliente == null) {
                JOptionPane.showMessageDialog(this, "No se pudo obtener el ID del cliente.");
                return;
            }

            // Obtener datos del formulario
            String nombreRutina = txtNombreRutina.getText().trim();
            int idEntrenador = SessionManager.getIdUsuario();

            if (nombreRutina.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre para la rutina.");
                return;
            }

            //  Obtener ejercicios seleccionados de jListEjerciciosAgregados
            List<Integer> ejerciciosSeleccionados = new ArrayList<>();
            DefaultListModel<String> modeloAgregados = (DefaultListModel<String>) jListEjerciciosAgregados.getModel();
            for (int i = 0; i < modeloAgregados.size(); i++) {
                String item = modeloAgregados.get(i);
                int idEjercicio = obtenerIdEjercicioPorNombre(item);
                ejerciciosSeleccionados.add(idEjercicio);
            }

            if (ejerciciosSeleccionados.size() < 4) {
                JOptionPane.showMessageDialog(this, "Debe agregar al menos 4 ejercicios.");
                return;
            }

            // 4. Crear rutina con el controlador
            try (Connection conn = DBConfig.getConnection()) {
                RutinaController controller = new RutinaController(conn);
                controller.crearRutina(idEntrenador, idCliente, nombreRutina, ejerciciosSeleccionados);
            }

            JOptionPane.showMessageDialog(this, "Rutina creada exitosamente.");
            limpiarFormulario();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al crear la rutina: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCrearRutinaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEjercicio;
    private javax.swing.JButton btnCrearRutina;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitarEjercicio;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEjercicios;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JLabel jLabelNombreRutina;
    private javax.swing.JLabel jLabelRutina;
    private javax.swing.JLabel jLabelTravel2;
    private javax.swing.JList<String> jListEjercicios;
    private javax.swing.JList<String> jListEjerciciosAgregados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtNombreRutina;
    // End of variables declaration//GEN-END:variables
}
