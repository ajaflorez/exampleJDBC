package vista;

import icon.MyIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class MainTool extends JToolBar {
    JButton buttonNew;
    JButton buttonOpen;
    JButton buttonSave;
    JButton buttonExit;
    

    public MainTool() {
        new MyIcon();
        buttonNew = new JButton(MyIcon.iconNew);
        buttonOpen = new JButton(MyIcon.iconOpen);
        buttonSave = new JButton(MyIcon.iconSave);
        buttonExit = new JButton(MyIcon.iconExit);
        
        buttonNew.setToolTipText("Nuevo Archivo");
        buttonOpen.setToolTipText("Abrir Archivo");
        buttonSave.setToolTipText("Grabar Archivo");
        buttonExit.setToolTipText("Salir");  
        
        this.add(buttonNew);
        this.add(buttonOpen);
        this.add(buttonSave);
        this.addSeparator();
        this.add(buttonExit);
        
        
        
        
    }
    
}
