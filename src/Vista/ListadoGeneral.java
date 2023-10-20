package Vista;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import Controlador.ControlCrearUsuario;
import Controlador.ControlListadoGeneral;
import Controlador.ControlListados;
import Utilerias.JButtonFuncion;
import Utilerias.JLabelTitulo;

public class ListadoGeneral extends JFrame {

  public Listados l;
  public ControlListadoGeneral clg;
  public JButton jbVolver;
  ModeloTabla mt;
  JTable tabla;

  public ListadoGeneral(Listados obj) {
    super("Listado General");
    l = obj;
    setSize(1000, 700);
    setLocationRelativeTo(null);
    getContentPane().setBackground(Color.GRAY);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setLayout(null);
    clg = new ControlListadoGeneral(this);
    addWindowListener(clg);
    crearGUI();
    llenarTabla();

    setVisible(true);
  }

  public void crearGUI() {
    ControlListadoGeneral clg = new ControlListadoGeneral(this);

    JPanel jp = new JPanel();
    jp.setBounds(100, 80, 800, 500);
    jp.setBackground(Color.white);
    jp.setLayout(null);
    add(jp);

    JLabelTitulo jt = new JLabelTitulo(
        60, "Listado General", this, "");
    add(jt);

    String encabezados[] = { "Cedula", "Nombre", "Apellido", "Email" };
    String datos[][] = { { "", "", "", "" } };

    mt = new ModeloTabla(datos, encabezados);
    tabla = new JTable(mt);

    tabla.setSelectionBackground(Color.lightGray);

    JScrollPane js = new JScrollPane(tabla);
    js.setBounds(60, 40, 700, 270);

    jp.add(js);

    jbVolver = new JButtonFuncion(60, "Volver listados", 'v', "/Imagenes/volver.png");
    jbVolver.addActionListener(clg);
    jp.add(jbVolver);

  }

  public void llenarTabla() {
    FileReader fr = null;
    boolean error = false;
    try {
      fr = new FileReader("usuarios.csv");
    } catch (Exception e) {
      error = true;
      JOptionPane.showMessageDialog(this, "Error al abrir el archivo 'usuarios.csv'");
    }
    if (!error) {
      BufferedReader br = new BufferedReader(fr);
      String linea = "";

      mt.removeRow(0);
      try {
        while ((linea = br.readLine()) != null) {
          String tokens[] = linea.split(";");
          mt.addRow(tokens);
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al leer el archivo 'usuarios.csv'");
      }
      try {
        fr.close();
      } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cerrar el archivo 'usuarios.csv'");
      }
    }
  }

}