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

public class GraficoGrupoSanguineo extends JFrame {

    JFreeChart chart;

    public GraficoGrupoSanguineo() {
        super("GRUPO SANGUINEO USUARIOS");
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
        double porcGrupoAP = 0;
        double porcGrupoOP = 0;
        double porcGrupoBP = 0;
        double porcGrupoABP = 0;
        double porcGrupoAN = 0;
        double porcGrupoON = 0;
        double porcGrupoBN = 0;
        double porcGrupoABN = 0;

        if(personal[1] != 0){
            porcGrupoAP = (personal[1] * 100) / usuariosTotales;
        }
        if(personal[2] != 0){
            porcGrupoOP = (personal[2] * 100) / usuariosTotales;
        }
        if(personal[3] != 0){
            porcGrupoBP = (personal[3] * 100) / usuariosTotales;
        }
        if(personal[4] != 0){
            porcGrupoABP = (personal[4] * 100) / usuariosTotales;
        }
        if(personal[5] != 0){
            porcGrupoAN = (personal[5] * 100) / usuariosTotales;
        }
        if(personal[6] != 0){
            porcGrupoON = (personal[6] * 100) / usuariosTotales;
        }
        if(personal[7] != 0){
            porcGrupoBN = (personal[7] * 100) / usuariosTotales;
        }
        if(personal[8] != 0){
            porcGrupoABN = (personal[8] * 100) / usuariosTotales;
        }

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("A+: " + porcGrupoAP, porcGrupoAP);
        data.setValue("O+: " + porcGrupoOP, porcGrupoOP);
        data.setValue("B+: " + porcGrupoBP, porcGrupoBP);
        data.setValue("AB+: " + porcGrupoABP, porcGrupoABP);
        data.setValue("A-: " + porcGrupoAN, porcGrupoAN);
        data.setValue("O-: " + porcGrupoON, porcGrupoON);
        data.setValue("B-: " + porcGrupoBN, porcGrupoBN);
        data.setValue("AB-: " + porcGrupoABN, porcGrupoABN);

        chart = ChartFactory.createPieChart3D(
                "GRUPO SANGUINEO", // chart title
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
        int[] personal = new int[9];
        int contadorUsu = 0;
        int contadorGruAP = 0;
        int contadorGruOP = 0;
        int contadorGruBP = 0;
        int contadorGruABP = 0;
        int contadorGruAN = 0;
        int contadorGruON = 0;
        int contadorGruBN = 0;
        int contadorGruABN = 0;
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
                    if(tokens[4].equals("A+")){
                        contadorGruAP = contadorGruAP + 1;
                    }
                    if(tokens[4].equals("Activo")){
                        contadorGruOP = contadorGruOP + 1;
                    }
                    if(tokens[4].equals("Activo")){
                        contadorGruBP = contadorGruBP + 1;
                    }
                    if(tokens[4].equals("Activo")){
                        contadorGruABP = contadorGruABP + 1;
                    }
                    if(tokens[4].equals("Activo")){
                        contadorGruAN = contadorGruAN + 1;
                    }
                    if(tokens[4].equals("Activo")){
                        contadorGruON = contadorGruON + 1;
                    }
                    if(tokens[4].equals("Activo")){
                        contadorGruBN = contadorGruBN + 1;
                    }
                    if(tokens[4].equals("Activo")){
                        contadorGruABN = contadorGruABN + 1;
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
        personal[1] = contadorGruAP;
        personal[2] = contadorGruOP;
        personal[3] = contadorGruBP;
        personal[4] = contadorGruABP;
        personal[5] = contadorGruAN;
        personal[6] = contadorGruON;
        personal[7] = contadorGruBN;
        personal[8] = contadorGruABN;
        return personal;
    }

    public static void main(final String[] args) {
        GraficoGrupoSanguineo ggs = new GraficoGrupoSanguineo();
    }
}
