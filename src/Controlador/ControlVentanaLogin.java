package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

import Vista.MenuPrincipal;
import Vista.VentanaLogin;

public class ControlVentanaLogin implements ActionListener, WindowListener {

    VentanaLogin vl;

    public ControlVentanaLogin(VentanaLogin vl) {
        this.vl = vl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(vl.jtVer)) {
            evento_jtVer();
        }
        if (e.getSource().equals(vl.jbCancelar)) {
            evento_salir();
        }
        if (e.getSource().equals(vl.jbingresar)) {
            evento_validar();
        }
        if (e.getSource().equals(vl.jtLogin)) {
            vl.jpPassw.requestFocus(); // al precionar enter, pasa el cursur al password
        }
    }

    private void evento_jtVer() {
        if (vl.jtVer.isSelected()) {
            vl.jtVer.setIcon(vl.ver);
            vl.jpPassw.setEchoChar((char) 0);// permitir ver los caracteres escritos en el JPassword
        } else {
            vl.jtVer.setIcon(vl.no_ver);
            vl.jpPassw.setEchoChar('*');
        }
        vl.jpPassw.requestFocus();
    }

    public boolean consultar_x_ced(String ced) {
        FileReader fr = null;// permite leer el archivo
        boolean error = false;
        boolean existe = false;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    e + "\n\nError al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);// clase que se utiliza para leer texto
            String linea = "";
            String[] tokens;

            try {
                while ((linea = br.readLine()) != null) { // readLine() es un método utilizado para leer una línea de
                                                          // texto
                    // System.out.println(linea);
                    tokens = linea.split(";");// divir los caracteres
                    // System.out.println(tokens[0]);
                    if (tokens[0].equals(ced)) {
                        existe = true;
                        break; // romper el while, para que no siga buscando en el archivo
                    }
                } // fin while
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al leer el archivo");
            }
            try {
                fr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al cerrar el archivo");
            }
        }
        return existe;
    }

    private void evento_validar() {
        String login = vl.jtLogin.getText();
        char caracteres[] = vl.jpPassw.getPassword(); // obtener los caracteres escritos como un arreglo de tipo char[]
        String passw = String.valueOf(caracteres);// Convertir el arreglo de char a String
        FileReader fr = null;// permite leer el archivo
        boolean error = false;
        //boolean existe = false;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    e + "\n\nError al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);// clase que se utiliza para leer texto
            String linea = "";
            String[] tokens;
            boolean existe = false;
            try {
                while ((linea = br.readLine()) != null) { // readLine() es un método utilizado para leer una línea de
                                                          // texto
                    // System.out.println(linea);
                    tokens = linea.split(";");// divir los caracteres
                    // System.out.println(tokens[0]);
                    if (login.equals("") || passw.equals("")) {
                        JOptionPane.showMessageDialog(vl, "Login y/o password no pueden ser vacios");
                        existe = true;
                        break;
                    } else {
                        if (login.equals(tokens[8]) && passw.equals(tokens[9])) {
                            // JOptionPane.showMessageDialog(vl, "Ingreso Correcto");
                            existe = true;
                            vl.setVisible(false);
                            vl.dispose();
                            // vl.mp.setVisible(true);
                            MenuPrincipal mp = new MenuPrincipal();
                            break;
                        } 
                    }

                } // fin while
                if (!existe) {
                    JOptionPane.showMessageDialog(vl, "Ingreso Incorrecto. Login y/o password incorrectos",
                                    "Error",JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al leer el archivo");
            }
            try {
                fr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        e + "\n\nError al cerrar el archivo");
            }
        }

        /*if (login.equals("") || passw.equals("")) {
            JOptionPane.showMessageDialog(vl, "Login y/o password no pueden ser vacios");
        } else {
            if (login.equals("admin") && passw.equals("admin")) {
                // JOptionPane.showMessageDialog(vl, "Ingreso Correcto");
                vl.setVisible(false);
                vl.dispose();
                // vl.mp.setVisible(true);
                MenuPrincipal mp = new MenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(vl, "Ingreso Incorrecto. Login y/o password incorrectos", "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        }*/
    }

    public void evento_salir() {
        int respuesta = JOptionPane.showConfirmDialog(vl,
                "¿Desea salir de la aplicación?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION)
            System.exit(0);
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
