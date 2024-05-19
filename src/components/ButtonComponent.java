/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import aps.Colors;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author guilh
 */
public class ButtonComponent extends JButton {

    private final int padding = 12;

    public ButtonComponent() {
        setBorder(new EmptyBorder(0, padding, 0, padding));
        setBackground(Colors.getPrimary());
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new Font("Verdana", 0, 12));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(Colors.getPrimaryLight());
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(Colors.getPrimary());
            }
        });
    }
}
