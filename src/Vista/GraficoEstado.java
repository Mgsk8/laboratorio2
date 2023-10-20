package Vista;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GraficoEstado extends JFrame {

    JFreeChart chart;

    public GraficoEstado() {
        super("ESTADO USUARIOS");
        setSize(800, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        int[] personal = listadoPersonal();
        crearGrafico(personal);

        ChartPanel panel = new ChartPanel(chart, false);
        panel.setBounds(10, 20, 760, 520);
        add(panel);

        setVisible(true);
    }

    public void crearGrafico(int[] personal) {
        
        for (int i = 0; i < personal.length; i++) {
            System.out.println("Posicion " + i + ": " + personal[i]);
        }
        int usuariosTotales = personal[0];
        double porcActivo = 0;
        double porcInactivo = 0;

        if(personal[1] != 0){
            porcActivo = (personal[1] * 100) / usuariosTotales;
        }
        if(personal[2] != 0){
            porcInactivo = (personal[2] * 100) / usuariosTotales;
        }

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Activos: " + porcActivo, porcActivo);
        data.setValue("Inactivos: " + porcInactivo, porcInactivo);

        chart = ChartFactory.createPieChart3D(
                "ESTADO", // chart title
                data, // data
                true, // include legend
                true,
                true);

        chart.setBackgroundPaint(Color.ORANGE);// Color de fonde de la ventana
        chart.getTitle().setPaint(Color.blue); // Dar color al titulo

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelBackgroundPaint(Color.ORANGE);// Color de las etiquetas
        plot.setForegroundAlpha(0.60f);// Color de el fondo del grafico

        // esto es lo que lo hace rotar
        Rotator rotator = new Rotator(plot);
        rotator.start();
    }

    public int [] listadoPersonal() {
        FileReader fr = null;
        boolean error = false;
        int[] personal = new int[3];
        int contadorUsu = 0;
        int contadorActivo = 0;
        int contadorInactivo = 0;
        try {
            fr = new FileReader("Usuarios.csv");
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    e + "\n\nError al abrir el archivo");
        }
        if (!error) {
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String tokens[];
            try {
                while ((linea = br.readLine()) != null) {
                    tokens = linea.split(";");
                    contadorUsu = contadorUsu + 1;
                    System.out.println(tokens[3]);
                    if(tokens[10].equals("Activo")){
                        contadorActivo = contadorActivo + 1;
                    }
                    if(tokens[10].equals("Inactivo")){
                        contadorInactivo = contadorInactivo + 1;
                    }
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
        personal[0] = contadorUsu;
        personal[1] = contadorActivo;
        personal[2] = contadorInactivo;
        return personal;
    }

    public static void main(final String[] args) {
        GraficoEstado ge = new GraficoEstado();
    }
}
