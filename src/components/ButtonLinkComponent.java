/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import aps.Colors;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author guilh
 */
public class ButtonLinkComponent extends JButton {

    private final int padding = 12;
    private boolean mouseOver = false;

    public ButtonLinkComponent() {
        setBorder(new EmptyBorder(0, padding, 0, padding));
        setFont(new Font("Verdana", 0, 12));
        setForeground(Colors.getPrimary());
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                mouseOver = true;
                setForeground(Colors.getPrimaryLight());
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
                setForeground(Colors.getPrimary());
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        
        g2.setColor(mouseOver ? Colors.getPrimaryLight() : Colors.getPrimary());

        g2.fillRect(0, height - 1, width, 1);
        g2.dispose();
    }

}
