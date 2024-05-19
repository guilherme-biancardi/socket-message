/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import aps.Colors;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author guilh
 */
public class MessageComponent extends JPanel implements MessageComponentInterface{

    private final boolean isCurrentUserMessage;
    private final String message;
    private final int height = 24;
    private final int gap = 20;

    public MessageComponent(boolean isCurrentUserMessage, String message, String date) {
        this.isCurrentUserMessage = isCurrentUserMessage;
        this.message = message;

        setLayout(new GridLayout(2, 1));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, this.height));
        setAlignmentX(CENTER_ALIGNMENT);

        JLabel label = new JLabel(this.message);
        label.setFont(new Font("verdana", 1, 13));
        label.setForeground(this.isCurrentUserMessage ? Colors.getPrimary() : Colors.getText());

        JPanel messageTextContent = new JPanel(new BorderLayout());
        messageTextContent.setBorder(new EmptyBorder(2, 8, 2, 8));
        messageTextContent.setBackground(Colors.getLightLightness());
        
        messageTextContent.add(label, this.isCurrentUserMessage ?  BorderLayout.EAST : BorderLayout.WEST);

        JLabel time = new JLabel(date);
        time.setForeground(Colors.getText());
        time.setFont(new Font("verdana", 2, 9));

        JPanel messageTimeContent = new JPanel(new BorderLayout());
        messageTimeContent.setBorder(new EmptyBorder(2, 8, 2, 8));
        messageTimeContent.add(time, this.isCurrentUserMessage ?  BorderLayout.EAST : BorderLayout.WEST);
        messageTimeContent.setBackground(Colors.getLightLightness());
        
        add(messageTextContent);
        add(messageTimeContent);
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
