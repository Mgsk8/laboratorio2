package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import Vista.ListadoEstadoxUsuario;

public class ControlListadoEstadoxUsuario implements ActionListener, WindowListener{

    public ListadoEstadoxUsuario leu;

    public ControlListadoEstadoxUsuario(ListadoEstadoxUsuario obj){
        leu = obj;
    }

    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(leu,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
    }

    public void volver(){
        leu.setVisible(false);
        leu.dispose();
        leu.fleu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(leu.jbVolver)){
            volver();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
         
    }

    @Override
    public void windowClosing(WindowEvent e) {
       evento_salir();
    }

    @Override
    public void windowClosed(WindowEvent e) {
         
    }

    @Override
    public void windowIconified(WindowEvent e) {
         
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
         
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
