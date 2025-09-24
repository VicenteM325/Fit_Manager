package com.archivos.fitmanager.ui.recepcion;

import com.archivos.fitmanager.dao.ClienteDAO;
import com.archivos.fitmanager.dao.PagoDAO;
import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Cliente;
import com.archivos.fitmanager.model.Pago;
import com.archivos.fitmanager.model.TipoPago;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class Pagos extends javax.swing.JPanel {

    /**
     * Creates new
     */
    public Pagos() {
        initComponents();
        jLabelPlan.setVisible(false);
        jComboBoxPlan.setVisible(false);
        jScrollPane1.setVisible(false);
        cargarClientes();
        cargarTiposPago();
    }

    private Pago construirPago() {
        Pago pago = new Pago();

        // ===================== MONTO =====================
        try {
            pago.setMonto(Double.parseDouble(txtMonto.getText().trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El monto ingresado no es válido.");
        }

        // ===================== CLIENTE =====================
        String clienteSeleccionado = (String) jComboBoxIdCliente.getSelectedItem();
        if (clienteSeleccionado != null && clienteSeleccionado.contains(" - ")) {
            int idCliente = Integer.parseInt(clienteSeleccionado.split(" - ")[0]);
            pago.setIdCliente(idCliente);
        } else {
            throw new IllegalArgumentException("Debe seleccionar un cliente válido.");
        }

        // ===================== TIPO DE PAGO =====================
        String tipoSeleccionado = (String) jComboBoxTipoPago.getSelectedItem();
        if (tipoSeleccionado != null && tipoSeleccionado.contains(" - ")) {
            String[] partes = tipoSeleccionado.split(" - ");
            int idTipoPago = Integer.parseInt(partes[0]);
            String nombreTipo = partes[1];

            pago.setIdTipoPago(idTipoPago);

            if ("BASICO".equalsIgnoreCase(nombreTipo)) {
                String planSeleccionado = (String) jComboBoxPlan.getSelectedItem();
                if (planSeleccionado == null || planSeleccionado.startsWith("Seleccione")) {
                    throw new IllegalArgumentException("Debe seleccionar un plan básico.");
                }
                int idPlan = Integer.parseInt(planSeleccionado.split(" - ")[0]);
                pago.setIdPlan(idPlan);

                try {
                    pago.setFechaInicio(Date.valueOf(txtFechaInicio.getText().trim()));
                    pago.setFechaFin(Date.valueOf(txtFechaFin.getText().trim()));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Las fechas deben estar en formato yyyy-MM-dd.");
                }
            }
        } else {
            throw new IllegalArgumentException("Debe seleccionar un tipo de pago válido.");
        }

        return pago;
    }
    
    private void actualizarMontoServicios() {
        List<String> seleccionados = jListServicios.getSelectedValuesList();
        double total = 0.0;

        try (Connection conn = DBConfig.getConnection()) {
            PagoDAO dao = new PagoDAO(conn);

            for (String servicio : seleccionados) {
                if (servicio.contains(" - ")) {
                    int idServicio = Integer.parseInt(servicio.split(" - ")[0]);
                    total += dao.obtenerCostoServicio(idServicio);
                }
            }

        } catch (SQLException e) {
            mostrarError("Error al calcular monto de servicios: " + e.getMessage());
        }

        txtMonto.setText(String.valueOf(total));
    }

    private List<Integer> obtenerServiciosSeleccionados() {
        List<Integer> servicios = new ArrayList<>();
        List<String> seleccionados = jListServicios.getSelectedValuesList();

        for (String item : seleccionados) {
            if (item.contains(" - ")) {
                int idServicio = Integer.parseInt(item.split(" - ")[0]);
                servicios.add(idServicio);
            }
        }
        return servicios;
    }

    private void cargarPlanes() {
        try (Connection conn = DBConfig.getConnection()) {
            PagoDAO dao = new PagoDAO(conn);
            List<String> planes = dao.obtenerPlanesBasicos();

            jComboBoxPlan.removeAllItems();
            jComboBoxPlan.addItem("Seleccione un plan");

            for (String plan : planes) {
                jComboBoxPlan.addItem(plan);
            }
        } catch (SQLException e) {
            mostrarError("Error al cargar planes: " + e.getMessage());
        }
    }

    private void cargarServiciosAdicionales() {
        try (Connection conn = DBConfig.getConnection()) {
            PagoDAO dao = new PagoDAO(conn);
            List<String> servicios = dao.obtenerServiciosAdicionales();

            DefaultListModel<String> modelo = new DefaultListModel<>();

            for (String servicio : servicios) {
                modelo.addElement(servicio);
            }

            jListServicios.setModel(modelo);
            jListServicios.addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                actualizarMontoServicios();
            }
        });

        } catch (SQLException e) {
            mostrarError("Error al cargar servicios adicionales: " + e.getMessage());
        }
    }

    private void cargarClientes() {
        try (Connection conn = DBConfig.getConnection()) {
            ClienteDAO dao = new ClienteDAO(conn);
            List<Cliente> clientes = dao.obtenerClientes();

            jComboBoxIdCliente.removeAllItems();
            jComboBoxIdCliente.addItem("Seleccione un cliente");

            for (Cliente c : clientes) {
                jComboBoxIdCliente.addItem(c.getIdCliente() + " - " + c.getNombre());
            }
        } catch (SQLException e) {
            mostrarError("Error al cargar clientes: " + e.getMessage());
        }
    }
    
    private void cargarTiposPago() {
        try (Connection conn = DBConfig.getConnection()) {
            PagoDAO dao = new PagoDAO(conn);
            List<TipoPago> tipos = dao.obtenerTiposPago();
            
            jComboBoxTipoPago.removeAllItems();
            jComboBoxTipoPago.addItem("Seleccione un tipo de pago");
            
            for (TipoPago tipo : tipos) {
                jComboBoxTipoPago.addItem(tipo.getIdTipoPago() + " - " + tipo.getNombre());
            }
        } catch (SQLException e) {
            mostrarError("Error al cargar tipos de pago: " + e.getMessage());
        }
    }

    private boolean validarFormulario() {
        if (txtMonto.getText().trim().isEmpty()) {
            mostrarAdvertencia("Debe ingresar un monto.");
            return false;
        }
        if (jComboBoxTipoPago.getSelectedIndex() <= 0) {
            mostrarAdvertencia("Debe seleccionar un tipo de pago.");
            return false;
        }
        if (jComboBoxIdCliente.getSelectedIndex() <= 0) {
            mostrarAdvertencia("Debe seleccionar un cliente.");
            return false;
        }
        return true;
    }

    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void limpiarFormulario() {
        txtMonto.setText("");
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
        jComboBoxPlan.setSelectedIndex(0);
        jComboBoxIdCliente.setSelectedIndex(0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTravel2 = new javax.swing.JLabel();
        jComboBoxPlan = new javax.swing.JComboBox<>();
        jLabelPago = new javax.swing.JLabel();
        jLabelPago1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnRegistrarPago = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jComboBoxIdCliente = new javax.swing.JComboBox<>();
        jLabelPago2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelPago3 = new javax.swing.JLabel();
        jLabelPago4 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        jComboBoxTipoPago = new javax.swing.JComboBox<>();
        jLabelPlan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListServicios = new javax.swing.JList<>();

        setBackground(new java.awt.Color(33, 45, 62));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelMenu.setBackground(new java.awt.Color(33, 45, 62));
        jpanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("____________");
        jpanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, 30));

        jLabelTravel2.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabelTravel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTravel2.setText("PAGO");
        jpanelMenu.add(jLabelTravel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 90, 60));

        add(jpanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 80));

        jComboBoxPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPlanActionPerformed(evt);
            }
        });
        add(jComboBoxPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 310, 40));

        jLabelPago.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPago.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPago.setText("Fecha Fin");
        add(jLabelPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 110, 30));

        jLabelPago1.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPago1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPago1.setText("Tipo Pago");
        add(jLabelPago1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 130, 30));

        jSeparator3.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator3.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 310, 10));

        btnRegistrarPago.setBackground(new java.awt.Color(73, 181, 172));
        btnRegistrarPago.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnRegistrarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPago.setText("REGISTRAR PAGO");
        btnRegistrarPago.setBorderPainted(false);
        btnRegistrarPago.setContentAreaFilled(false);
        btnRegistrarPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarPago.setFocusPainted(false);
        btnRegistrarPago.setFocusable(false);
        btnRegistrarPago.setRequestFocusEnabled(false);
        btnRegistrarPago.setVerifyInputWhenFocusTarget(false);
        btnRegistrarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPagoActionPerformed(evt);
            }
        });
        add(btnRegistrarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 210, 60));

        jSeparator4.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator4.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 310, 10));

        jComboBoxIdCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIdClienteActionPerformed(evt);
            }
        });
        add(jComboBoxIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 310, 40));

        jLabelPago2.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPago2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPago2.setText("Cliente");
        add(jLabelPago2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 80, 30));

        jSeparator5.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator5.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 310, 10));

        jLabelPago3.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPago3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPago3.setText("Monto");
        add(jLabelPago3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 80, 30));

        jLabelPago4.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPago4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPago4.setText("Fecha Inicio");
        add(jLabelPago4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 140, 30));

        txtFechaFin.setBackground(new java.awt.Color(33, 45, 62));
        txtFechaFin.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtFechaFin.setForeground(new java.awt.Color(195, 218, 227));
        txtFechaFin.setBorder(null);
        txtFechaFin.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 570, 50));

        txtMonto.setBackground(new java.awt.Color(33, 45, 62));
        txtMonto.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtMonto.setForeground(new java.awt.Color(195, 218, 227));
        txtMonto.setBorder(null);
        txtMonto.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 340, 50));

        txtFechaInicio.setBackground(new java.awt.Color(33, 45, 62));
        txtFechaInicio.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtFechaInicio.setForeground(new java.awt.Color(195, 218, 227));
        txtFechaInicio.setBorder(null);
        txtFechaInicio.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 350, 50));

        jComboBoxTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoPagoActionPerformed(evt);
            }
        });
        add(jComboBoxTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 310, 40));

        jLabelPlan.setText("Seleccione");
        add(jLabelPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        jListServicios.setBackground(new java.awt.Color(33, 45, 62));
        jListServicios.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jListServicios.setForeground(new java.awt.Color(255, 255, 255));
        jListServicios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListServicios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListServiciosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListServicios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 310, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPlanActionPerformed
       String seleccionado = (String) jComboBoxPlan.getSelectedItem();
    if (seleccionado != null && seleccionado.contains(" - ")) {
        int idSeleccionado = Integer.parseInt(seleccionado.split(" - ")[0]);

        try (Connection conn = DBConfig.getConnection()) {
            PagoDAO dao = new PagoDAO(conn);

            String tipoPago = (String) jComboBoxTipoPago.getSelectedItem();
            if (tipoPago != null && tipoPago.contains(" - ")) {
                String nombreTipo = tipoPago.split(" - ")[1];

                double costo = 0.0;
                if ("BASICO".equalsIgnoreCase(nombreTipo)) {
                    costo = dao.obtenerCostoPlan(idSeleccionado);
                } else if ("SERVICIO_ADICIONAL".equalsIgnoreCase(nombreTipo)) {
                    costo = dao.obtenerCostoServicio(idSeleccionado);
                }

                txtMonto.setText(String.valueOf(costo));
            }

        } catch (SQLException e) {
            mostrarError("Error al obtener costo: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jComboBoxPlanActionPerformed

    private void btnRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPagoActionPerformed
        try (Connection conn = DBConfig.getConnection()) {
            if (!validarFormulario()) {
                return;
            }

            Pago pago = construirPago();
            List<Integer> servicios = obtenerServiciosSeleccionados();
            PagoDAO dao = new PagoDAO(conn);
            boolean exito = dao.registrarPagoConServicios(pago, servicios);
            if (pago.getIdTipoPago() == 1) {
                exito = dao.registrarPagoBasico(pago);
            } else if (pago.getIdTipoPago() == 2) {
                int idPago = dao.registrarPagoServicio(pago);
                exito = idPago > 0;
            }

            if (exito) {
                JOptionPane.showMessageDialog(this, "Pago registrado con éxito.");
                limpiarFormulario();
                jComboBoxPlan.setVisible(false);
                jScrollPane1.setVisible(false);
                jLabelPlan.setVisible(false);
            } else {
                mostrarError("No se pudo registrar el pago.");
            }

        } catch (SQLException ex) {
            mostrarError("Error de base de datos: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            mostrarError("Error inesperado: " + ex.getMessage());
            ex.printStackTrace();
    }
    }//GEN-LAST:event_btnRegistrarPagoActionPerformed

    private void jComboBoxIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxIdClienteActionPerformed

    private void jComboBoxTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoPagoActionPerformed
        String seleccionado = (String) jComboBoxTipoPago.getSelectedItem();
        if (seleccionado != null && seleccionado.contains(" - ")) {
            String nombreTipo = seleccionado.split(" - ")[1];
            if ("BASICO".equalsIgnoreCase(nombreTipo)) {
                jLabelPlan.setVisible(true);
                jComboBoxPlan.setVisible(true);
                cargarPlanes();
            } else if("SERVICIO_ADICIONAL".equalsIgnoreCase(nombreTipo)){
                jLabelPlan.setVisible(true);
                jScrollPane1.setVisible(true);
                cargarServiciosAdicionales();
                
            }else {
                jLabelPlan.setVisible(false);
                jScrollPane1.setVisible(false);
                jComboBoxPlan.setVisible(false);
            }
        }
    }//GEN-LAST:event_jComboBoxTipoPagoActionPerformed

    private void jListServiciosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListServiciosValueChanged
        if (!evt.getValueIsAdjusting()) { 
        actualizarMontoServicios();
    }
    }//GEN-LAST:event_jListServiciosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarPago;
    private javax.swing.JComboBox<String> jComboBoxIdCliente;
    private javax.swing.JComboBox<String> jComboBoxPlan;
    private javax.swing.JComboBox<String> jComboBoxTipoPago;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPago;
    private javax.swing.JLabel jLabelPago1;
    private javax.swing.JLabel jLabelPago2;
    private javax.swing.JLabel jLabelPago3;
    private javax.swing.JLabel jLabelPago4;
    private javax.swing.JLabel jLabelPlan;
    private javax.swing.JLabel jLabelTravel2;
    private javax.swing.JList<String> jListServicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel jpanelMenu;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
