package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class MainPanel extends Container{
    
    MainTool mainTool;
    PanelBody panelBody;
    
    // se tiene que especificar el Layout a Utilizar
    public MainPanel() {
        this.setLayout(new BorderLayout());        
 
        // TOOLBAR  - PAGE_START
        mainTool = new MainTool();
        this.add(mainTool, BorderLayout.PAGE_START);
        
        // PANEL BODY - CENTER
        panelBody = new PanelBody();
        this.add(panelBody, BorderLayout.CENTER);
                
    }
    
    
}
