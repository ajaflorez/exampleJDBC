package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class FrameMaster extends JFrame{
    PanelTable panelTable;
    PanelButton panelButton;
    //PanelNewCenter panelNewCenter;

    public FrameMaster() {        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);       
                
        // PANEL BODY  -    CENTER
        panelTable = new PanelTable();
        this.add(panelTable,BorderLayout.CENTER);
        
        // PANEL BUTTON  -  PAGE_END
        panelButton = new PanelButton(this);        
        this.add(panelButton, BorderLayout.PAGE_END);
    }
    
}
