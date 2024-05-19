/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import aps.Colors;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author guilh
 */
public class NotificationComponent extends JPanel implements MessageComponentInterface {

    private final String message;
    private final int height = 12;
    private final int gap = 16;

    public NotificationComponent(String message) {
        this.message = message;

        setLayout(new GridLayout(2, 1));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, this.height));
        setAlignmentX(CENTER_ALIGNMENT);

        JLabel label = new JLabel(this.message);
        label.setFont(new Font("verdana", 1, 10));
        label.setForeground(Colors.getPrimary());

        JPanel messageTextContent = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messageTextContent.setBorder(new EmptyBorder(2, 8, 2, 8));
        messageTextContent.setBackground(Colors.getLightLightness());
        
        messageTextContent.add(label);
        
        add(messageTextContent);
    }

    @Override
    public int getGap() {
        return gap;
    }
    
    @Override
    public int getTotalHeight(){
        return gap + height;
    }
}
