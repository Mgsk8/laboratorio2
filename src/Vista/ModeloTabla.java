package Vista;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel{
    public ModeloTabla(Object datos[][], Object encabezados[]){
        super(datos, encabezados);
    }

    public boolean isCellEditable(int row, int column){
        return false;
    }
}
