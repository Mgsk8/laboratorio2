/*
Proposito: Gestiona las interacciones del usuario en la vista ConsultarUsuario.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  03/01/2023
version: 1.1
*/

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.Usuario;
import Vista.ConsultarUsuario;
import Vista.CrearUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControlConsultarUsuario implements ActionListener, WindowListener{

    ConsultarUsuario cu;
    
    
    public ControlConsultarUsuario(ConsultarUsuario obj){
        cu = obj;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cu.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(cu.jbLimpiar)) {
            limpiar();
        }
        if (e.getSource().equals(cu.jbConsultar)) {
            String ced = cu.jtCedula.getText();
            buscarUsario(ced);
        }
    }

    private void limpiar() {
        cu.jtCedula.setText("");
        cu.jtNom.setText("");
        cu.jtApe.setText("");
        cu.jcTipoUsuario.setSelectedItem("Cliente");
        cu.jcGrupoSanguineo.setSelectedItem("A+");
        cu.jcDia.setSelectedItem("1");
        cu.jcMes.setSelectedItem("1");
        cu.jcYear.setSelectedItem(cu.yearActual);
        cu.jtEmail.setText("");
        cu.jtApe.requestFocus();
    }

    private void volver() {
        cu.setVisible(false);
        cu.dispose();
        cu.mp.setVisible(true);
    }
    
    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(cu,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
    }
    
    public void buscarUsario(String obj){
        String buscar = obj;
        for (int i = 0; i < cu.mp.usuarios.size(); i++) {
            Usuario u = cu.mp.usuarios.get(i);
            if(buscar.equals(u.getCedula())){
                cu.jtCedula.setText(u.getCedula());
                cu.jtNom.setText(u.getNombre());
                cu.jtApe.setText(u.getApellido());
                cu.jcTipoUsuario.setSelectedItem(u.getTipoUsuario());
                cu.jcGrupoSanguineo.setSelectedItem(u.getGrupoSanguineo());
                cu.jcDia.setSelectedItem(u.getDia());
                cu.jcMes.setSelectedItem(u.getMes());
                cu.jcYear.setSelectedItem(u.getYear());
                cu.jtEmail.setText(u.getEmail());
                if("Activo".equals(u.getEstado())) cu.jrActivo.setSelected(true);
                else cu.jrInactivo.setSelected(true);
            }
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
