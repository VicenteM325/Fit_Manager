package com.archivos.fitmanager.ui.admin;

import com.archivos.fitmanager.dao.EmpleadoDAO;
import com.archivos.fitmanager.dao.RolDAO;
import com.archivos.fitmanager.dao.SucursalDAO;
import com.archivos.fitmanager.model.Empleado;
import com.archivos.fitmanager.model.Rol;
import com.archivos.fitmanager.model.Sucursal;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class RegistrarEmpleado extends javax.swing.JPanel {
    
    private List<Sucursal> listaSucursales;  
    private List<Rol> listaRoles;  

    /**
     * Creates new form RegistrarEmpleado
     */
    public RegistrarEmpleado() {
        initComponents();
        cargarSucursales();
        cargarRoles();
    }

    private void cargarSucursales() {
        SucursalDAO dao = new SucursalDAO();
        listaSucursales = dao.obtenerTodas();

        jComboBoxSucursal.removeAllItems();
        for (Sucursal s : listaSucursales) {
            jComboBoxSucursal.addItem(s.getNombre()); // solo nombres
        }
    }

    private void cargarRoles() {
    RolDAO dao = new RolDAO();
    listaRoles = dao.obtenerTodos(); 

    jComboBoxRol.removeAllItems();
    for (Rol r : listaRoles) {
        jComboBoxRol.addItem(r.getNombre());
    }
}
    private void limpiarFormulario() {
        txtNombres1.setText("");
        txtApellidos1.setText("");
        txtTelefono1.setText("");
        txtUsuarioLogin1.setText("");
        txtpassword.setText("");
        jComboBoxRol.setSelectedIndex(-1);
        jComboBoxSucursal.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelMenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTravel1 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelApellido1 = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelLogin1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtNombres1 = new javax.swing.JTextField();
        txtApellidos1 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelPassword1 = new javax.swing.JLabel();
        txtUsuarioLogin1 = new javax.swing.JTextField();
        jComboBoxRol = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();
        jLabelPassword2 = new javax.swing.JLabel();
        jComboBoxSucursal = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(33, 45, 62));
        setPreferredSize(new java.awt.Dimension(1040, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanelMenu.setBackground(new java.awt.Color(33, 45, 62));
        jpanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("____________");
        jpanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, 30));

        jLabelTravel1.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabelTravel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTravel1.setText("REGISTRAR EMPLEADO");
        jpanelMenu.add(jLabelTravel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 400, 60));

        add(jpanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 80));

        jLabelNombre.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombres");
        add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, 30));

        jLabelPassword.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Contraseña");
        add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 190, 30));

        jLabelApellido1.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelApellido1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido1.setText("Apellidos");
        add(jLabelApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 160, 30));

        jLabelTelefono.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Teléfono");
        add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 170, 30));

        jLabelLogin1.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelLogin1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogin1.setText("Usuario Login");
        add(jLabelLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 210, 30));

        jSeparator1.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator1.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 310, 10));

        jSeparator2.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator2.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 310, 10));

        jSeparator3.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator3.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 310, 10));

        jSeparator4.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator4.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 310, 10));

        txtNombres1.setBackground(new java.awt.Color(33, 45, 62));
        txtNombres1.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtNombres1.setForeground(new java.awt.Color(195, 218, 227));
        txtNombres1.setBorder(null);
        txtNombres1.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtNombres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 570, 50));

        txtApellidos1.setBackground(new java.awt.Color(33, 45, 62));
        txtApellidos1.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtApellidos1.setForeground(new java.awt.Color(195, 218, 227));
        txtApellidos1.setBorder(null);
        txtApellidos1.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtApellidos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 510, 50));

        txtTelefono1.setBackground(new java.awt.Color(33, 45, 62));
        txtTelefono1.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtTelefono1.setForeground(new java.awt.Color(195, 218, 227));
        txtTelefono1.setBorder(null);
        txtTelefono1.setCaretColor(new java.awt.Color(73, 181, 172));
        add(txtTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 430, 40));

        txtpassword.setBackground(new java.awt.Color(33, 45, 62));
        txtpassword.setFont(txtpassword.getFont().deriveFont(txtpassword.getFont().getSize()+7f));
        txtpassword.setForeground(new java.awt.Color(195, 218, 227));
        txtpassword.setBorder(null);
        txtpassword.setCaretColor(new java.awt.Color(73, 181, 172));
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 360, 50));

        jSeparator5.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator5.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 310, 10));

        jLabelPassword1.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPassword1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword1.setText("Rol");
        add(jLabelPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 50, 30));

        txtUsuarioLogin1.setBackground(new java.awt.Color(33, 45, 62));
        txtUsuarioLogin1.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        txtUsuarioLogin1.setForeground(new java.awt.Color(195, 218, 227));
        txtUsuarioLogin1.setBorder(null);
        txtUsuarioLogin1.setCaretColor(new java.awt.Color(73, 181, 172));
        txtUsuarioLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioLogin1ActionPerformed(evt);
            }
        });
        add(txtUsuarioLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 340, 40));

        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRolActionPerformed(evt);
            }
        });
        add(jComboBoxRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 310, 40));

        btnIngresar.setBackground(new java.awt.Color(73, 181, 172));
        btnIngresar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("REGISTRAR");
        btnIngresar.setBorderPainted(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setFocusable(false);
        btnIngresar.setRequestFocusEnabled(false);
        btnIngresar.setVerifyInputWhenFocusTarget(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 210, 60));

        jLabelPassword2.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelPassword2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword2.setText("Sucursal");
        add(jLabelPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 100, 30));

        jComboBoxSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSucursalActionPerformed(evt);
            }
        });
        add(jComboBoxSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 310, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtUsuarioLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioLogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioLogin1ActionPerformed

    private void jComboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRolActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            // Crear nuevo empleado
            Empleado emp = new Empleado();
            emp.setNombre(txtNombres1.getText().trim());
            emp.setApellido(txtApellidos1.getText().trim());
            emp.setTelefono(txtTelefono1.getText().trim());
            emp.setUsuarioLogin(txtUsuarioLogin1.getText().trim());
            emp.setContrasena(new String(txtpassword.getPassword()));

            // Obtener el rol 
            int indexRol = jComboBoxRol.getSelectedIndex();
            if (indexRol >= 0 && listaRoles != null) {
                Rol seleccionado = listaRoles.get(indexRol);
                emp.setIdRol(seleccionado.getIdRol());
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un rol.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener sucursal seleccionada
            int indexSucursal = jComboBoxSucursal.getSelectedIndex();
            if (indexSucursal >= 0 && listaSucursales != null) {
                Sucursal seleccionada = listaSucursales.get(indexSucursal);
                emp.setIdSucursal(seleccionada.getIdSucursal());
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Guardar empleado
            EmpleadoDAO dao = new EmpleadoDAO();
            if (dao.registrarEmpleado(emp)) {
                JOptionPane.showMessageDialog(this, "Empleado registrado con éxito.");
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el empleado.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Excepción", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void jComboBoxSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSucursalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private javax.swing.JComboBox<String> jComboBoxSucursal;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelLogin1;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelPassword2;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTravel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel jpanelMenu;
    private javax.swing.JTextField txtApellidos1;
    private javax.swing.JTextField txtNombres1;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtUsuarioLogin1;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
