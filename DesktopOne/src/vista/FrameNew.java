package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FrameNew extends JFrame{
    PanelButton panelButton;
    PanelNewCenter panelNewCenter;

    public FrameNew() throws Exception{
        super("Nuevo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);       
                
        // PANEL BODY  -    CENTER
        panelNewCenter = new PanelNewCenter();
        this.add(panelNewCenter,BorderLayout.CENTER);
        
        // PANEL BUTTON  -  PAGE_END
        panelButton = new PanelButton(this);        
        this.add(panelButton, BorderLayout.PAGE_END);
    }
    
    
}
