package vista;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Medico;

public class MedicoTM extends AbstractTableModel{
    private static final int IDMEDICO = 0;
    private static final int PATERNO = 1;
    private static final int MATERNO = 2;
    private static final int NOMBRES = 3;
    private static final int IDESPECIAL = 4;
    
    private String[] columnNames = {"Id", "Paterno", "Materno", "Nombres", "Especial"};
    private List<Medico> medicos;

    public MedicoTM(List<Medico> medicos) {
        this.medicos = medicos;
    }
    
    

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return 0;
    }
    
}
