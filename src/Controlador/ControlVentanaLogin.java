package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import Vista.MenuPrincipal;
import Vista.VentanaLogin;

public class ControlVentanaLogin implements ActionListener, WindowListener{

    VentanaLogin vl;
    
    public ControlVentanaLogin(VentanaLogin vl){
        this.vl = vl;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource().equals(vl.jtVer)){
            evento_jtVer();
        }
        if(e.getSource().equals(vl.jbCancelar)){
            evento_salir();
        }
        if(e.getSource().equals(vl.jbingresar)){
            evento_validar();
        }
    }
    private void evento_jtVer() {
        if (vl.jtVer.isSelected()) {
            vl.jtVer.setIcon(vl.ver);
            vl.jpPassw.setEchoChar((char) 0);//permitir ver los caracteres escritos en el JPassword
        }else{
            vl.jtVer.setIcon(vl.no_ver);
            vl.jpPassw.setEchoChar('*');
        }
        vl.jpPassw.requestFocus();
    }

    private void evento_validar() {
        String login = vl.jtLogin.getText();
        char caracteres[] = vl.jpPassw.getPassword(); //obtener los caracteres escritos como un arreglo de tipo char[]
        String passw = String.valueOf(caracteres);//Convertir el arreglo de char a String

        System.out.println(login +" " + passw); //mostrar el password

        if(login.equals("") || passw.equals("")){
            JOptionPane.showMessageDialog(vl, "Login y/o password no pueden ser vacios");
        }else{
            if (login.equals("admin") && passw.equals("admin")) {
                //JOptionPane.showMessageDialog(vl, "Ingreso Correcto");
                vl.setVisible(false);
                vl.dispose();
                //vl.mp.setVisible(true);
                MenuPrincipal mp = new MenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(vl, "Ingreso Incorrecto. Login y/o password incorrectos", "Error",
                JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    public void evento_salir(){
        int respuesta = JOptionPane.showConfirmDialog(vl,
                "¿Desea salir de la aplicación?",
                "Confirmación", 
                JOptionPane.YES_NO_OPTION);
        if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
     }  
    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        evento_salir();
    }
    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
