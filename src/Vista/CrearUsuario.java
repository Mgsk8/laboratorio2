/*
Proposito: Muestra en pantalla multiples campos para la creación de usuarios, con botones para guardar, limpiar y volver al menú principal.
@author 
    Jhon Alex Rodríguez Benítez - 2264363
    Miguel Angel Escobar Marín - 2264305
    John Alejandro Vallarino Cruz - 2264332
Fecha de ultima modificacion  26/09/2023
version: 1.0
*/

package Vista;

import Controlador.ControlCrearUsuario;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


public class CrearUsuario extends JFrame{
    
    public JButton jbVolver, jbGuardar, jbLimpiar;
    public MenuPrincipal mp;
    public JTextField jtCedula, jtNom, jtApe, jtEmail, jtPassword;
    public JComboBox<String> jcDia, jcMes, jcYear, jcTipoUsuario, jcGrupoSanguineo;
    public int yearActual = Calendar.getInstance().get(Calendar.YEAR);
    //public int yearActual = c1.get(Calendar.YEAR);
    ControlCrearUsuario ccu;
    
    public CrearUsuario(MenuPrincipal mp){
        super("Ingreso de datos");
        this.mp = mp;
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        ccu = new ControlCrearUsuario(this);
        addWindowListener(ccu);
        crearGUI();
        
        setVisible(true);
    }
    
    public void crearGUI(){
        ControlCrearUsuario ccu = new ControlCrearUsuario(this);
        
        JPanel jp = new JPanel();
        jp.setBounds(100, 80, 800, 500);
        jp.setBackground(Color.white);
        jp.setLayout(null);
        add(jp);
        
        JLabelTitulo jt = new JLabelTitulo(
                60, "Ingresar Usuario", this, "/Imagenes/agregar-usuario.png");
        add(jt);
        
        JLabel jlCed = new JLabel("Cedula:");
        jlCed.setBounds(40, 110, 120, 30);
        jp.add(jlCed);
        
        jtCedula = new JTextField();
        jtCedula.setBounds(130, 110, 200, 30);
        jp.add(jtCedula);
        
        JLabel jlNom = new JLabel("Nombre:");
        jlNom.setBounds(40, 160, 120, 30);
        jp.add(jlNom);
        
        jtNom = new JTextField();
        jtNom.setBounds(130, 160, 200, 30);
        jp.add(jtNom);
        
        JLabel jlApe = new JLabel("Apellido:");
        jlApe.setBounds(40, 210, 120, 30);
        jp.add(jlApe);
        
        jtApe = new JTextField();
        jtApe.setBounds(130, 210, 200, 30);
        jp.add(jtApe);
        
        JLabel jlEmail = new JLabel("Email:");
        jlEmail.setBounds(40, 260, 120, 30);
        jp.add(jlEmail);
        
        jtEmail = new JTextField();
        jtEmail.setBounds(130, 260, 200, 30);
        jp.add(jtEmail);
        
        JLabel jlPassword = new JLabel("Password:");
        jlPassword.setBounds(40, 310, 120, 30);
        jp.add(jlPassword);
        
        jtPassword = new JTextField();
        jtPassword.setBounds(130, 310, 200, 30);
        jp.add(jtPassword);
        
        JLabel jlTipoUsario = new JLabel("Tipo de usuario:");
        jlTipoUsario.setBounds(370, 110, 150, 30);
        jp.add(jlTipoUsario);
        
        JLabel jlGrupoSanguineo = new JLabel("Grupo Sanguineo:");
        jlGrupoSanguineo.setBounds(370, 160, 150, 30);
        jp.add(jlGrupoSanguineo);
        
        jcTipoUsuario = new JComboBox<>();
        String tipoUsuario[] = {"Administrador", "Supervisor", "Entrenador", "Recepcionista", "Cliente"};
        for (int i = 0; i < tipoUsuario.length; i++) {
            jcTipoUsuario.addItem(tipoUsuario[i]);
        }
        
        jcGrupoSanguineo = new JComboBox<>();
        String grupoSanguineo[] = {"A+","O+","B+","AB+","A-","O-","B-","AB-"};
        for (int i = 0; i < grupoSanguineo.length; i++) {
            jcGrupoSanguineo.addItem(grupoSanguineo[i]); 
        }
        
        jcDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            jcDia.addItem(i + "");
        }
        
        jcMes = new JComboBox<>();
        for (int i = 1; i <= 12; i++) {
            jcMes.addItem(i + "");
        }
        
        jcYear = new JComboBox<>();
        for (int i = yearActual; i >= 1900; i--) {
            jcYear.addItem(i + "");
        }
        
        jcTipoUsuario.setBounds(480, 110, 150, 30);
        jp.add(jcTipoUsuario);
        
        jcGrupoSanguineo.setBounds(480, 160,  50, 30);
        jp.add(jcGrupoSanguineo);
        
        jcDia.setBounds(480, 210, 150, 30);
        jp.add(jcDia);
        
        jcMes.setBounds(480, 260, 150, 30);
        jp.add(jcMes);
        
        jcYear.setBounds(480, 310, 150, 30);
        jp.add(jcYear);
        
        JLabel jlDia = new JLabel("Dia:");
        jlDia.setBounds(370, 210, 150, 30);
        jp.add(jlDia);
        
        JLabel jlMes = new JLabel("Mes:");
        jlMes.setBounds(370, 260, 150, 30);
        jp.add(jlMes);
        
        JLabel jlYear = new JLabel("Año:");
        jlYear.setBounds(370, 310, 150, 30);
        jp.add(jlYear);
       
        
        
        jbVolver = new JButtonFuncion(60, "Volver al menu", 'v', "/Imagenes/volver.png");
        jbVolver.addActionListener(ccu);
        jp.add(jbVolver);

        jbLimpiar = new JButtonFuncion(225, "Limpiar", 'L', "/Imagenes/limpiar.png");
        jbLimpiar.addActionListener(ccu);
        jp.add(jbLimpiar);

        jbGuardar = new JButtonFuncion(225+165, "Guardar", 'G', "/Imagenes/GuardarUser.png");
        jbGuardar.addActionListener(ccu);
        jp.add(jbGuardar);
      
    }
}
