package com.archivos.fitmanager.ui.entrenador;

import com.archivos.fitmanager.controller.EjercicioController;
import com.archivos.fitmanager.controller.EquipoController;
import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Ejercicio;
import com.archivos.fitmanager.model.Equipo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class Ejercicios extends javax.swing.JPanel {
    
    private EjercicioController ejercicioController;

    /**
     * Creates new form Ejercicios
     */
    public Ejercicios() {
        initComponents();
        try {
        Connection conn = DBConfig.getConnection();
        this.ejercicioController = new EjercicioController(conn);

        // Usamos el controlador de equipos
        EquipoController equipoController = new EquipoController(conn);
            List<Equipo> equipos = equipoController.obtenerEquipos();

            Map<String, Integer> mapEquipos = new HashMap<>();
            jComboBoxEquipo.removeAllItems();
            for (Equipo eq : equipos) {
                jComboBoxEquipo.addItem(eq.getNombre());
                mapEquipos.put(eq.getNombre(), eq.getIdEquipo());
            }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar: " + e.getMessage());
    }
    }

    private void limpiarCampos() {
        txtNombreEjercicio.setText("");
        jSpinnerSeries.setValue(0);
        jSpinnerRepeticiones.setValue(0);
        jSpinnerDuracion.setValue(0);
        jComboBoxEquipo.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreEjercicio = new javax.swing.JTextField();
        jLabelNombreEjercicios = new javax.swing.JLabel();
        jLabelSeries = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSpinnerSeries = new javax.swing.JSpinner();
        jLabelRepeticiones = new javax.swing.JLabel();
        jSpinnerRepeticiones = new javax.swing.JSpinner();
        jLabelDuracion = new javax.swing.JLabel();
        jSpinnerDuracion = new javax.swing.JSpinner();
        jComboBoxEquipo = new javax.swing.JComboBox<>();
        jLabelEquipo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabelTravel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(33, 45, 62));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreEjercicio.setBackground(new java.awt.Color(33, 45, 62));
        txtNombreEjercicio.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        txtNombreEjercicio.setForeground(new java.awt.Color(195, 218, 227));
        txtNombreEjercicio.setBorder(null);
        txtNombreEjercicio.setCaretColor(new java.awt.Color(73, 181, 172));
        txtNombreEjercicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreEjercicioKeyReleased(evt);
            }
        });
        add(txtNombreEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 300, 50));

        jLabelNombreEjercicios.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelNombreEjercicios.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreEjercicios.setText("Nombre");
        add(jLabelNombreEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 30));

        jLabelSeries.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelSeries.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeries.setText("Series");
        add(jLabelSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 80, 30));

        jSeparator3.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator3.setForeground(new java.awt.Color(73, 181, 172));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 310, 10));

        jSpinnerSeries.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        add(jSpinnerSeries, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 300, 40));

        jLabelRepeticiones.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelRepeticiones.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRepeticiones.setText("Repeticiones");
        add(jLabelRepeticiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 140, 30));

        jSpinnerRepeticiones.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        add(jSpinnerRepeticiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 300, 40));

        jLabelDuracion.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelDuracion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDuracion.setText("Duración (min)");
        add(jLabelDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 160, 30));

        jSpinnerDuracion.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        add(jSpinnerDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 300, 40));

        jComboBoxEquipo.setBackground(new java.awt.Color(33, 45, 62));
        jComboBoxEquipo.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jComboBoxEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquipoActionPerformed(evt);
            }
        });
        add(jComboBoxEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 300, 40));

        jLabelEquipo.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabelEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEquipo.setText("Equipo");
        add(jLabelEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 90, 30));

        btnGuardar.setBackground(new java.awt.Color(73, 181, 172));
        btnGuardar.setFont(new java.awt.Font("Gotham Extra Light", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("REGISTRAR");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFocusable(false);
        btnGuardar.setRequestFocusEnabled(false);
        btnGuardar.setVerifyInputWhenFocusTarget(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 210, 60));

        jLabelTravel2.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabelTravel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTravel2.setText("EJERCICIOS");
        add(jLabelTravel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 170, 60));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("____________");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEjercicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEjercicioKeyReleased
        
    }//GEN-LAST:event_txtNombreEjercicioKeyReleased

    private void jComboBoxEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquipoActionPerformed
        
    }//GEN-LAST:event_jComboBoxEquipoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String nombre = txtNombreEjercicio.getText();
            int series = (Integer) jSpinnerSeries.getValue();
            int repeticiones = (Integer) jSpinnerRepeticiones.getValue();
            int duracion = (Integer) jSpinnerDuracion.getValue();
            int idEquipo = jComboBoxEquipo.getSelectedIndex() + 1; 

            Ejercicio e = new Ejercicio();
            e.setNombre(nombre);
            e.setSeries(series);
            e.setRepeticiones(repeticiones);
            e.setDuracionMinutos(duracion);
            e.setIdEquipo(idEquipo);

            boolean creado = ejercicioController.crearEjercicio(e);

            if (creado) {
                JOptionPane.showMessageDialog(this, "Ejercicio registrado con éxito ✅");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar el ejercicio ❌");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> jComboBoxEquipo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelEquipo;
    private javax.swing.JLabel jLabelNombreEjercicios;
    private javax.swing.JLabel jLabelRepeticiones;
    private javax.swing.JLabel jLabelSeries;
    private javax.swing.JLabel jLabelTravel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinnerDuracion;
    private javax.swing.JSpinner jSpinnerRepeticiones;
    private javax.swing.JSpinner jSpinnerSeries;
    private javax.swing.JTextField txtNombreEjercicio;
    // End of variables declaration//GEN-END:variables
}
