package com.archivos.fitmanager.ui.entrenador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author vicente
 */
public class Entrenador extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Entrenador.class.getName());
    Ejercicios ejercicio = new Ejercicios();
    Rutinas rutinas = new Rutinas();
    ConsultaRutinas consultas = new ConsultaRutinas();

    int xMouse, yMouse;

    public Entrenador() {
        initComponents();
        Color hoverColor = new Color(60, 171, 175);
        Color defaultColor = new Color(73, 181, 172);

        //Lista paneles en menu
        ArrayList<JPanel> panels = new ArrayList<>();
        panels.add(btnHome);
        panels.add(btnRutina);
        panels.add(btnEjercicios);
        panels.add(btnConsultas);

        for (JPanel p : panels) {
            p.setBackground(defaultColor);
            addHoverEffect(p, hoverColor, defaultColor);
        }
    }

    private void addHoverEffect(JPanel panel, Color entered, Color exited) {
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(entered);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBackground(exited);
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabeza = new javax.swing.JPanel();
        jPanelCerrar = new javax.swing.JPanel();
        LabelExit = new javax.swing.JLabel();
        jpanelMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelHome = new javax.swing.JLabel();
        btnRutina = new javax.swing.JPanel();
        jLabelRutina = new javax.swing.JLabel();
        jLabelStart = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTravel1 = new javax.swing.JLabel();
        btnEjercicios = new javax.swing.JPanel();
        jLabelEjercicios = new javax.swing.JLabel();
        jLabelStart1 = new javax.swing.JLabel();
        btnConsultas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelStart2 = new javax.swing.JLabel();
        jPanelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCabeza.setBackground(new java.awt.Color(33, 45, 62));
        panelCabeza.setForeground(new java.awt.Color(255, 255, 255));
        panelCabeza.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelCabezaMouseDragged(evt);
            }
        });
        panelCabeza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCabezaMousePressed(evt);
            }
        });

        jPanelCerrar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCerrar.setForeground(new java.awt.Color(0, 0, 0));
        jPanelCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelCerrarMouseExited(evt);
            }
        });

        LabelExit.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        LabelExit.setText("  X");
        LabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCerrarLayout = new javax.swing.GroupLayout(jPanelCerrar);
        jPanelCerrar.setLayout(jPanelCerrarLayout);
        jPanelCerrarLayout.setHorizontalGroup(
            jPanelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCerrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelExit, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );
        jPanelCerrarLayout.setVerticalGroup(
            jPanelCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCerrarLayout.createSequentialGroup()
                .addComponent(LabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCabezaLayout = new javax.swing.GroupLayout(panelCabeza);
        panelCabeza.setLayout(panelCabezaLayout);
        panelCabezaLayout.setHorizontalGroup(
            panelCabezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezaLayout.createSequentialGroup()
                .addContainerGap(999, Short.MAX_VALUE)
                .addComponent(jPanelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelCabezaLayout.setVerticalGroup(
            panelCabezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezaLayout.createSequentialGroup()
                .addComponent(jPanelCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(panelCabeza, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1040, 60));

        jpanelMenu.setBackground(new java.awt.Color(33, 45, 62));
        jpanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setBackground(new java.awt.Color(73, 181, 172));
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRINCIPAL");

        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-outline.png"))); // NOI18N
        jLabelHome.setText("jLabel4");

        javax.swing.GroupLayout btnHomeLayout = new javax.swing.GroupLayout(btnHome);
        btnHome.setLayout(btnHomeLayout);
        btnHomeLayout.setHorizontalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHomeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        btnHomeLayout.setVerticalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHomeLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelHome))
                .addGap(22, 22, 22))
        );

        jpanelMenu.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 270, 70));

        btnRutina.setBackground(new java.awt.Color(73, 181, 172));
        btnRutina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRutina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRutinaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRutinaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRutinaMouseExited(evt);
            }
        });

        jLabelRutina.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabelRutina.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRutina.setText("RUTINAS");

        jLabelStart.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rutina.png"))); // NOI18N

        javax.swing.GroupLayout btnRutinaLayout = new javax.swing.GroupLayout(btnRutina);
        btnRutina.setLayout(btnRutinaLayout);
        btnRutinaLayout.setHorizontalGroup(
            btnRutinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRutinaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelStart)
                .addGap(35, 35, 35)
                .addComponent(jLabelRutina)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        btnRutinaLayout.setVerticalGroup(
            btnRutinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnRutinaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelStart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(btnRutinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRutina, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpanelMenu.add(btnRutina, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 270, 70));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("____________");
        jpanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jLabelTravel1.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 24)); // NOI18N
        jLabelTravel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTravel1.setText("Fit Manager");
        jpanelMenu.add(jLabelTravel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 190, 60));

        btnEjercicios.setBackground(new java.awt.Color(73, 181, 172));
        btnEjercicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEjercicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEjerciciosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEjerciciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEjerciciosMouseExited(evt);
            }
        });

        jLabelEjercicios.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabelEjercicios.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEjercicios.setText("EJERCICIOS");

        jLabelStart1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ejercicios.png"))); // NOI18N

        javax.swing.GroupLayout btnEjerciciosLayout = new javax.swing.GroupLayout(btnEjercicios);
        btnEjercicios.setLayout(btnEjerciciosLayout);
        btnEjerciciosLayout.setHorizontalGroup(
            btnEjerciciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEjerciciosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelStart1)
                .addGap(26, 26, 26)
                .addComponent(jLabelEjercicios)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        btnEjerciciosLayout.setVerticalGroup(
            btnEjerciciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnEjerciciosLayout.createSequentialGroup()
                .addGroup(btnEjerciciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(btnEjerciciosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEjercicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, btnEjerciciosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpanelMenu.add(btnEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 270, -1));

        btnConsultas.setBackground(new java.awt.Color(73, 181, 172));
        btnConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultasMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CONSULTAS");

        jLabelStart2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ConsultaCliente.png"))); // NOI18N

        javax.swing.GroupLayout btnConsultasLayout = new javax.swing.GroupLayout(btnConsultas);
        btnConsultas.setLayout(btnConsultasLayout);
        btnConsultasLayout.setHorizontalGroup(
            btnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnConsultasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelStart2)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        btnConsultasLayout.setVerticalGroup(
            btnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnConsultasLayout.createSequentialGroup()
                .addGroup(btnConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnConsultasLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelStart2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btnConsultasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jpanelMenu.add(btnConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 346, 270, 60));

        getContentPane().add(jpanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 660));

        jPanelContent.setBackground(new java.awt.Color(33, 45, 62));
        jPanelContent.setForeground(new java.awt.Color(255, 255, 255));
        jPanelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 1040, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_LabelExitMouseClicked

    private void jPanelCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanelCerrarMouseClicked

    private void jPanelCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCerrarMouseEntered
        jPanelCerrar.setBackground(Color.red);
    }//GEN-LAST:event_jPanelCerrarMouseEntered

    private void jPanelCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCerrarMouseExited
        jPanelCerrar.setBackground(Color.white);
    }//GEN-LAST:event_jPanelCerrarMouseExited

    private void panelCabezaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabezaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelCabezaMouseDragged

    private void panelCabezaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabezaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelCabezaMousePressed

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        //  ShowPanel(principal);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered

    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited

    }//GEN-LAST:event_btnHomeMouseExited

    private void btnRutinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutinaMouseClicked
           ShowPanel(rutinas);
    }//GEN-LAST:event_btnRutinaMouseClicked

    private void btnRutinaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutinaMouseEntered

    }//GEN-LAST:event_btnRutinaMouseEntered

    private void btnRutinaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRutinaMouseExited

    }//GEN-LAST:event_btnRutinaMouseExited

    private void btnEjerciciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEjerciciosMouseClicked
          ShowPanel(ejercicio);
    }//GEN-LAST:event_btnEjerciciosMouseClicked

    private void btnEjerciciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEjerciciosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEjerciciosMouseEntered

    private void btnEjerciciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEjerciciosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEjerciciosMouseExited

    private void btnConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseClicked
         ShowPanel(consultas);
    }//GEN-LAST:event_btnConsultasMouseClicked

    private void btnConsultasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultasMouseEntered

    private void btnConsultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultasMouseExited

    
    private void ShowPanel(JPanel panel){
        panel.setSize(1040, 600);
        panel.setLocation(0, 0);

        jPanelContent.removeAll();
        jPanelContent.setLayout(new BorderLayout());
        jPanelContent.add(panel, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();
      
      }
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Entrenador().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelExit;
    private javax.swing.JPanel btnConsultas;
    private javax.swing.JPanel btnEjercicios;
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnRutina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelEjercicios;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelRutina;
    private javax.swing.JLabel jLabelStart;
    private javax.swing.JLabel jLabelStart1;
    private javax.swing.JLabel jLabelStart2;
    private javax.swing.JLabel jLabelTravel1;
    private javax.swing.JPanel jPanelCerrar;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jpanelMenu;
    private javax.swing.JPanel panelCabeza;
    // End of variables declaration//GEN-END:variables
}
