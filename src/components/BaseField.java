package components;

import aps.Colors;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author guilh
 */
public class BaseField {

    private final int fieldPadding = 12;
    private final JTextComponent component;
    private int maxLength = 128;
    private boolean isValid = true;

    public BaseField(JTextComponent component) {
        this.component = component;

        initMaxLength();
    }

    public void setLineBorder(Color color) {
        LineBorder lineBorder = new LineBorder(color, 1);
        EmptyBorder padding = new EmptyBorder(0, fieldPadding, 0, fieldPadding);

        component.setBorder(new CompoundBorder(lineBorder, padding));
    }

    public void initComponent() {
        component.setForeground(Colors.getText());
        setLineBorder(Colors.getLightDarkness());
        component.setBackground(Colors.getLightLightness());
        component.setFont(new Font("Verdana", 0, 12));

        component.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                Color primary = Colors.getPrimary();

                if (isValid) {
                    setLineBorder(primary);
                }
                component.setForeground(primary);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (isValid) {
                    setLineBorder(Colors.getLightDarkness());
                }
                component.setForeground(Colors.getText());
            }
        });
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    private void initMaxLength() {
        // Criando um DocumentFilter para limitar o comprimento do texto
        PlainDocument doc = (PlainDocument) component.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() > maxLength) {
                    Toolkit.getDefaultToolkit().beep(); // Emitindo um som de aviso
                    return;
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length > maxLength) {
                    Toolkit.getDefaultToolkit().beep(); // Emitindo um som de aviso
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
    }

    public void setError(boolean valid) {
        if (valid) {
            setLineBorder(Colors.getLightDarkness());
        } else {
            setLineBorder(Color.red);
        }
        
        isValid = valid;
    }

}
