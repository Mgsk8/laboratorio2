/*
Proposito: Gestiona las interacciones del usuario en la vista CrearUsuario.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  03/10/2023
version: 1.1
*/

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.Usuario;
import Vista.ActualizarUsuario;
import Vista.ConsultarUsuario;
import Vista.CrearUsuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ControlActualizarUsuario implements ActionListener, WindowListener{
    
    
    ActualizarUsuario au;
    ArrayList<Usuario> usuarios;
    boolean ExisteUsario;
    
    public ControlActualizarUsuario(ActualizarUsuario obj){
        au = obj;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        usuarios = au.mp.usuarios; 
        int posicion = 0;
        if (e.getSource().equals(au.jbVolver)) {
            volver();
        }
        if (e.getSource().equals(au.jbLimpiar)) {
            limpiar();
        }
        if (e.getSource().equals(au.jbConsultar)) {
            ExisteUsario = false;
            String ced = au.jtCedula.getText();
            limpiar();
            volverNoEditables();
            llenarCampos(ced);
            if(ExisteUsario == false)JOptionPane.showMessageDialog(au,
                        "El usuario a buscar no existe.", "Usuario No Encontrado", posicion);
            posicion = llenarCampos(ced);
        }
        if (e.getSource().equals(au.jbActualizar)) {
            actualizarDatos(posicion);
        }
    }

    private void limpiar() {
        au.jtCedula.setText("");
        au.jtNom.setText("");
        au.jtApe.setText("");
        au.jcTipoUsuario.setSelectedItem("Cliente");
        au.jcGrupoSanguineo.setSelectedItem("A+");
        au.jcDia.setSelectedItem("1");
        au.jcMes.setSelectedItem("1");
        au.jcYear.setSelectedItem(au.yearActual);
        au.jtEmail.setText("");
        au.jtPassword.setText("");
        au.jtApe.requestFocus();
    }
    
    private void volverEditables(){
        au.jtNom.setEditable(true);
        au.jtApe.setEditable(true);
        au.jtEmail.setEditable(true);
        au.jtPassword.setEditable(true);
        au.jcTipoUsuario.setEnabled(true);
        au.jcGrupoSanguineo.setEnabled(true);
        au.jcDia.setEnabled(true);
        au.jcMes.setEnabled(true);
        au.jcYear.setEnabled(true);
        au.jrActivo.setEnabled(true);
        au.jrInactivo.setEnabled(true);
    }
    
    private void volverNoEditables(){
        au.jtNom.setEditable(false);
        au.jtApe.setEditable(false);
        au.jtEmail.setEditable(false);
        au.jtPassword.setEditable(false);
        au.jcTipoUsuario.setEnabled(false);
        au.jcGrupoSanguineo.setEnabled(false);
        au.jcDia.setEnabled(false);
        au.jcMes.setEnabled(false);
        au.jcYear.setEnabled(false);
        au.jrActivo.setEnabled(false);
        au.jrInactivo.setEnabled(false);
    }
    
    private int llenarCampos(String ced){
        int posicion = 0;
        //ArrayList<Usuario> usuarios = cu.mp.usuarios;
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);
                if(ced.equals(usuario.getCedula())){
                    ExisteUsario = true;
                    posicion = i;
                    volverEditables();
                    String cedu = usuario.getCedula();
                    au.jtCedula.setText(cedu);
                    String nom = usuario.getNombre();
                    au.jtNom.setText(nom);
                    String ape = usuario.getApellido();
                    au.jtApe.setText(ape);
                    String email = usuario.getEmail();
                    au.jtEmail.setText(email);
                    String password = usuario.getPassword();
                    au.jtPassword.setText(password);
                    /*String fechaNac = usuario.getFechaNacimiento();
                    String[] fechaSeparada = fechaNac.split("/");*/
                    String diaNac = usuario.getDia();
                    au.jcDia.setSelectedItem(diaNac);
                    String mesNac  = usuario.getMes();
                    au.jcMes.setSelectedItem(mesNac);
                    String yearNac  = usuario.getYear();
                    au.jcYear.setSelectedItem(yearNac);
                    String grupoS = usuario.getGrupoSanguineo();
                    au.jcTipoUsuario.setSelectedItem(grupoS);
                    String tipoU = usuario.getTipoUsuario();
                    au.jcTipoUsuario.setSelectedItem(tipoU);
                    if("Activo".equals(usuario.getEstado())) au.jrActivo.setSelected(true);
                    else au.jrInactivo.setSelected(true);
                }
            }
        return posicion;
    }
    
    private void actualizarDatos(int posicion){
        String ced = au.jtCedula.getText();
        String nom = au.jtNom.getText();
        String ape = au.jtApe.getText();
        String email = au.jtEmail.getText();
        String password = au.jtPassword.getText();
        String dia = (String) au.jcDia.getSelectedItem();
        String mes = (String) au.jcMes.getSelectedItem();
        String year = (String) au.jcYear.getSelectedItem();
        String grupoS = (String) au.jcGrupoSanguineo.getSelectedItem();
        String tipoU = (String) au.jcTipoUsuario.getSelectedItem();
        //String fecha = dia + "/" + mes + "/" + year;
        String estado = "Activo";
        if(au.jrActivo.isSelected()) estado = "Activo";
        if(au.jrInactivo.isSelected()) estado = "Inactivo";
        Usuario usuario = new Usuario(ced, nom, ape, tipoU, grupoS,dia, mes ,year, email, password, estado);
        //usuarios.set(posicion, usuario); 
        
        int resp = JOptionPane.showConfirmDialog(au, 
                "desea actualizar los datos?", 
                 "Confirmación", 
                JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            usuarios.set(posicion, usuario); 
            int resp2 = JOptionPane.showConfirmDialog(au, 
                "datos guardados, \n desea actualizar otro usuario?", 
                 "Confirmación", 
                JOptionPane.YES_NO_OPTION);
            if (resp2 == JOptionPane.YES_OPTION) {
                limpiar();
                volverNoEditables();
            }
            else{
                volver();
            }
        }else{
            int resp3 = JOptionPane.showConfirmDialog(au, 
                "desea actualizar otro usuario?", 
                 "Confirmación", 
                JOptionPane.YES_NO_OPTION);
            if (resp3 == JOptionPane.YES_OPTION) {
                limpiar();
                volverNoEditables();
            }
            else{
                volver();
            }
        }
    }

    private void volver() {
        au.setVisible(false);
        au.dispose();
        au.mp.setVisible(true);
    }
    
    public void evento_salir(){
       int respuesta = JOptionPane.showConfirmDialog(au,
               "¿Desea salir de la aplicación?",
               "Confirmación", 
               JOptionPane.YES_NO_OPTION);
       if(respuesta == JOptionPane.YES_OPTION) System.exit(0);
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
