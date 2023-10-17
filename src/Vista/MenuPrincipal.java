/*
Proposito: Mostrar en pantalla múltiples botones que nos permite la navegación entre ventanas 
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/


package Vista;

import Controlador.ControlMenuPrincipal;
import Modelo.Usuario;
import Utilerias.JButtonMenu;
import Utilerias.JButtonRoll;
import Utilerias.JLabelTitulo;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuPrincipal extends JFrame{

    public JButton jbNuevoUsuario, jbVentanaListado, jbConsultarUsuario, jbActualizar;
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    ControlMenuPrincipal cmp;
    
    
    public JButton jbLogo, jbAcerca;
    
    public MenuPrincipal(){
        super("Menú principal");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
        Image icono = new ImageIcon(getClass().getResource("/Imagenes/Menu_p.png")).getImage();
        setIconImage(icono);
        cmp = new ControlMenuPrincipal(this);
        addWindowListener((WindowListener) cmp);
        
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Menu Principal", this, "/Imagenes/hogar.png");
        add(jt);
        ControlMenuPrincipal cmp = new ControlMenuPrincipal(this);
        jbNuevoUsuario = new JButtonMenu((1000-400)/2, 150, 400, 50, 
                "Nuevo Usuario", "Ir a crear usuarios", 
                "/imagenes/agregar-usuario.png", 'C', this);
        jbNuevoUsuario.setBorderPainted(false);
        jbNuevoUsuario.setFocusPainted(false);
        jbNuevoUsuario.addActionListener(cmp);
        add(jbNuevoUsuario);
        
        jbConsultarUsuario = new JButtonMenu((1000-400)/2, 250, 400, 50, 
                "Consultar usuario", "Ir a consulta de usuarios", 
                "/imagenes/Consultar.png", 'C', this);
        jbConsultarUsuario.addActionListener(cmp);
        add(jbConsultarUsuario);
        
        jbActualizar = new JButtonMenu((1000-400)/2, 350, 400, 50, 
                "Actualizar Usuario", "Ir a actualizacion de usuarios", 
                "/imagenes/Actualizar.png", 'A', this);
        jbActualizar.addActionListener(cmp);
        add(jbActualizar);
        
        jbAcerca = new JButtonMenu((1000-400)/2, 450, 400, 50, 
                "Acerca de...", "Ir a Acerca de", 
                "/imagenes/info.png", 'A', this);
        jbAcerca.setBorderPainted(false);
        jbAcerca.addActionListener(cmp);
        add(jbAcerca);
       
        
        jbLogo = new JButtonRoll(800, 480, 150, 150, 
                "", "Logo", 
                "/Imagenes/LogoBlanco.png", "/Imagenes/LogoNegro.png", 'L', this);
        add(jbLogo);
        
        
    }

    public static void main(String[] args) {
        MenuPrincipal obj = new MenuPrincipal();
    }
    
}
