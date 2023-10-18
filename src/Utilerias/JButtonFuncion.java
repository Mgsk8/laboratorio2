package Utilerias;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButtonFuncion extends JButton {
    
    public JButtonFuncion(int x, String texto, char letra, String imagen){

        setBounds(x, 360, 150, 80);
        setText(texto);
        ImageIcon ii = new ImageIcon(getClass().getResource(imagen));
        setIcon(ii);
        setMnemonic(letra);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
