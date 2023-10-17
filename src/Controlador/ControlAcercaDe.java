/*
Proposito: Gestiona las interacciones del usuario en la vista AcercaDe.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  03/10/2023
version: 1.1
*/
package Controlador;

import Vista.AcercaDe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;


public class ControlAcercaDe implements ActionListener{
    
    AcercaDe ad;
    
    public ControlAcercaDe(AcercaDe obj){
        ad = obj;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ad.jbVolver)) {
            volver();
        }
    }
    public void volver(){
        ad.setVisible(false);
        ad.dispose();
    }     
    
    

    /*@Override
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

    }*/
}
