/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class Alert {

    private static void showAlert(String title, String message, int type, boolean sound) {
        if (sound) {
            Toolkit.getDefaultToolkit().beep(); // Emitindo um som de aviso
        }

        JOptionPane.showMessageDialog(null, message, title, type);
    }

    public static void error(String title, String message) {
        showAlert(title, message, JOptionPane.ERROR_MESSAGE, true);
    }

    public static void success(String title, String message) {
        showAlert(title, message, JOptionPane.PLAIN_MESSAGE, false);
    }
}
