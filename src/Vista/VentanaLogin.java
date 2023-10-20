package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.naming.ldap.Control;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import Controlador.ControlVentanaLogin;
import Utilerias.LimitadorCaracteres;

public class VentanaLogin extends JFrame{
    
    public JTextField jtLogin;
    public JPasswordField jpPassw;
    public JToggleButton jtVer; //para ver u ocultar el password
    public JButton jbCancelar, jbingresar;
    public ImageIcon ver, no_ver;
    ControlVentanaLogin cvl;
    //public MenuPrincipal mp;

    public VentanaLogin(){
        super("Ingreso al sistema");
        setSize(400, 300);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        crerGUI();
        cvl = new ControlVentanaLogin(this);
        addWindowListener((WindowListener) cvl);
        setVisible(true);
    }
    private void crerGUI() {
        ControlVentanaLogin cvl = new ControlVentanaLogin(this);

        ImageIcon im = new ImageIcon(getClass().getResource("/Imagenes/login.png"));
        JLabel jlTitulo = new JLabel("Ingreso al sistema", im, JLabel.CENTER);
        jlTitulo.setBounds(0, 0, 400, 75);
        jlTitulo.setOpaque(true);
        jlTitulo.setBackground(Color.white);
        jlTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
        //jlTitulo.setHorizontalAlignment(JLabel.CENTER);
        add(jlTitulo);

        JLabel jlLogin = new JLabel("Login");
        jlLogin.setBounds(10, 90, 100, 30);
        jlLogin.setHorizontalAlignment(JLabel.RIGHT);
        add(jlLogin);

        jtLogin = new JTextField();
        jtLogin.setBounds(120, 90, 150, 30);
        jtLogin.setDocument(new LimitadorCaracteres(jtLogin, 30, ABORT));   
        jtLogin.addActionListener(cvl);  
        add(jtLogin);

        JLabel jlPass = new JLabel("password");
        jlPass.setBounds(10, 140, 100, 30);
        jlPass.setHorizontalAlignment(JLabel.RIGHT);
        add(jlPass);

        jpPassw = new JPasswordField();
        jpPassw.setBounds(120, 140, 150, 30);
        jpPassw.setEchoChar('*');
        add(jpPassw);

        ver  = new ImageIcon(getClass().getResource("/Imagenes/visible.png"));
        no_ver  = new ImageIcon(getClass().getResource("/Imagenes/no-visible.png"));
        jtVer = new JToggleButton(no_ver);
        jtVer.setBounds(275, 140, 50, 30);
        jtVer.setBorderPainted(false);//quitar el borde del boton
        jtVer.setFocusPainted(false);//quitar el recuadro del foco del boton
        jtVer.setContentAreaFilled(false);//quita el color de fondo del boton 
        jtVer.addActionListener(cvl);
        add(jtVer);

        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(45, 200, 150, 35);
        jbCancelar.addActionListener(cvl);
        
        add(jbCancelar);

        jbingresar = new JButton("Ingresar");
        jbingresar.setBounds(205, 200, 150, 35);
        jbingresar.addActionListener(cvl);
        jbingresar.setMnemonic('I');
        add(jbingresar);
    }
    public static void main(String[] args) {
        VentanaLogin vl = new VentanaLogin();
    }
}
