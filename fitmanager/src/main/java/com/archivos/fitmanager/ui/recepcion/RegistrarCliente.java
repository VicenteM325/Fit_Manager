package com.archivos.fitmanager.ui.recepcion;


import com.archivos.fitmanager.dao.ClienteDAO;
import com.archivos.fitmanager.dao.EmpleadoDAO;
import com.archivos.fitmanager.dao.MembresiaDAO;
import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Cliente;
import com.archivos.fitmanager.model.Empleado;
import com.archivos.fitmanager.model.Membresia;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class RegistrarCliente extends javax.swing.JPanel {

    private List<Empleado> listaEntrenadores;
    private List<Membresia> listaMembresias;


    public RegistrarCliente(){
        initComponents();
        cargarDatos();
    }
    
    private void cargarDatos() {
        try (Connection conn = DBConfig.getConnection()) {
            cargarEntrenadores();
            cargarMembresias(conn);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + ex.getMessage(),
                    "Error de BD", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void cargarEntrenadores() {
        EmpleadoDAO dao = new EmpleadoDAO();
        listaEntrenadores = dao.obtenerEntrenadores();

        jComboBoxEntrenador.removeAllItems();
        jComboBoxEntrenador.addItem("Seleccione...");
        for (Empleado e : listaEntrenadores) {
            jComboBoxEntrenador.addItem(e.getNombre());
        }
    }

    private void cargarMembresias(Connection conn) {
        MembresiaDAO dao = new MembresiaDAO(conn);
        listaMembresias = dao.listarMembresias(); 

        jComboBoxMembresia.removeAllItems();
        jComboBoxMembresia.addItem("Seleccione...");
        if (listaMembresias != null) {
            for (Membresia m : listaMembresias) {
                jComboBoxMembresia.addItem(m.getTipoNombre());
            }
        }
    }

    private void limpiarFormulario() {
        txtNombres1.setText("");
        txtApellidos1.setText("");
        txtTelefono1.setText("");
        jComboBoxEntrenador.setSelectedIndex(0);
        jComboBoxMembresia.setSelectedIndex(0);
    }

    private boolean validarFormulario() {
    if (txtNombres1.getText().trim().isEmpty() ||
        txtApellidos1.getText().trim().isEmpty() ||
        txtTelefono1.getText().trim().isEmpty()) {

        mostrarAdvertencia("Debe completar todos los campos.");
        return false;
    }

    if (jComboBoxEntrenador.getSelectedIndex() <= 0 ||
        jComboBoxMembresia.getSelectedIndex() <= 0) {

        mostrarAdvertencia("Debe seleccionar un Entrenador y una Membresía.");
        return false;
    }
        return true;
    }

    private Cliente construirCliente() {
        Cliente cli = new Cliente();
        cli.setNombre(txtNombres1.getText().trim());
        cli.setApellido(txtApellidos1.getText().trim());
        cli.setTelefono(txtTelefono1.getText().trim());

        int idxEntrenador = jComboBoxEntrenador.getSelectedIndex() - 1;
        int idxMembresia = jComboBoxMembresia.getSelectedIndex() - 1;

        Empleado entrenador = listaEntrenadores.get(idxEntrenador);
        Membresia membresia = listaMembresias.get(idxMembresia);

        cli.setIdEntrenador(entrenador.getIdEmpleado());
        cli.setIdMembresia(membresia.getIdMembresia());

        return cli;
    }

    private void mostrarAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTravel1 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido1 = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtNombres1 = new javax.swing.JTextField();
        txtApellidos1 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        jComboBoxEntrenador = new javax.swing.JComboBox<>();
        jLabelEntrenador = new javax.swing.JLabel();
        jComboBoxMembresia = new javax.swing.JComboBox<>();
        jLabelMembresia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(33, 45, 62));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelMenu.setBackground(new java.awt.Color(33, 45, 62));
        jpanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("____________");
        jpanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, 30));

        jLabelTravel1.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabelTravel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTravel1.setText("REGISTRAR CLIENTE");
        jpanelMenu.add(jLabelTravel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 320, 60));

        add(jpanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 80));

        jLabelNombre.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombres");
        add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 160, 30));

        jLabelApellido1.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelApellido1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido1.setText("Apellidos");
        add(jLabelApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 160, 30));

        jLabelTelefono.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Teléfono");
        add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 170, 30));

        jSeparator2.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator2.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 310, 10));

        jSeparator3.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator3.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 310, 10));

        jSeparator4.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator4.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 310, 10));

        txtNombres1.setBackground(new java.awt.Color(33, 45, 62));
        txtNombres1.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtNombres1.setForeground(new java.awt.Color(195, 218, 227));
        txtNombres1.setBorder(null);
        txtNombres1.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtNombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 570, 50));

        txtApellidos1.setBackground(new java.awt.Color(33, 45, 62));
        txtApellidos1.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtApellidos1.setForeground(new java.awt.Color(195, 218, 227));
        txtApellidos1.setBorder(null);
        txtApellidos1.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtApellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 510, 50));

        txtTelefono1.setBackground(new java.awt.Color(33, 45, 62));
        txtTelefono1.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtTelefono1.setForeground(new java.awt.Color(195, 218, 227));
        txtTelefono1.setBorder(null);
        txtTelefono1.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 430, 40));

        btnRegistrarCliente.setBackground(new java.awt.Color(73, 181, 172));
        btnRegistrarCliente.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnRegistrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarCliente.setText("REGISTRAR");
        btnRegistrarCliente.setBorderPainted(false);
        btnRegistrarCliente.setContentAreaFilled(false);
        btnRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarCliente.setFocusPainted(false);
        btnRegistrarCliente.setFocusable(false);
        btnRegistrarCliente.setRequestFocusEnabled(false);
        btnRegistrarCliente.setVerifyInputWhenFocusTarget(false);
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
        add(btnRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 210, 60));

        jComboBoxEntrenador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEntrenadorActionPerformed(evt);
            }
        });
        add(jComboBoxEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 310, 40));

        jLabelEntrenador.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelEntrenador.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEntrenador.setText("Entrenador");
        add(jLabelEntrenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 120, 30));

        jComboBoxMembresia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMembresiaActionPerformed(evt);
            }
        });
        add(jComboBoxMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 310, 40));

        jLabelMembresia.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelMembresia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMembresia.setText("Membresia");
        add(jLabelMembresia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        try (Connection conn = DBConfig.getConnection()) {

            if (!validarFormulario()) {
                return; // Si la validación falla no avanza
            }

            Cliente cli = construirCliente();

            ClienteDAO dao = new ClienteDAO(conn);
            if (dao.registrarClienteCompleto(cli)) {
                JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");
                limpiarFormulario();
            } else {
                mostrarError("Error al registrar el cliente.");
            }

        } catch (SQLException ex) {
            mostrarError("Error de base de datos: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            mostrarError("Error inesperado: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void jComboBoxEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEntrenadorActionPerformed

    private void jComboBoxMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMembresiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMembresiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JComboBox<String> jComboBoxEntrenador;
    private javax.swing.JComboBox<String> jComboBoxMembresia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelEntrenador;
    private javax.swing.JLabel jLabelMembresia;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTravel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel jpanelMenu;
    private javax.swing.JTextField txtApellidos1;
    private javax.swing.JTextField txtNombres1;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables
}
