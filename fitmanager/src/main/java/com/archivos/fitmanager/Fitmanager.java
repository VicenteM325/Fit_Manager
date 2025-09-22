
package com.archivos.fitmanager;

import com.archivos.fitmanager.ui.Login;
import javax.swing.SwingUtilities;

/**
 *
 * @author vicente
 */
public class Fitmanager {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() ->{
            Login ventana = new Login();
            ventana.setVisible(true);
        });
    }
}
