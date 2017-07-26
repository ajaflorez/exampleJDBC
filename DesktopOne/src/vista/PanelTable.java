package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelTable extends JPanel {
    JScrollPane scroll;
    JTable table;

    public PanelTable() {
        scroll = new JScrollPane();        
        table = new JTable();
        
        scroll.setViewportView(table);
        this.add(scroll);
    }
    
    
}
