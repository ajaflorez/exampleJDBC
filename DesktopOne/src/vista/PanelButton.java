package vista;

import icon.MyIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelButton extends JPanel {
    JButton botonNew;
    JButton botonEdit;
    JButton botonDelete;    
    JButton botonExit;
    // El JPanel tiene por defecto el FlowLayout y en CENTER
    public PanelButton(JFrame parentFrame) {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));                
        new MyIcon();
                
        botonNew = new JButton("Nuevo", MyIcon.iconNew);
        botonNew.setToolTipText("Nuevo");
        
        botonEdit = new JButton("Editar", MyIcon.iconEdit);
        botonEdit.setToolTipText("Editar");
        
        botonDelete = new JButton("Eliminar", MyIcon.iconDelete);
        botonDelete.setToolTipText("Eliminar");
        
        botonExit = new JButton("Salir", MyIcon.iconExit);
        botonExit.setToolTipText("Salir");
        
        botonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.dispose();
            }
        });
        
        this.add(botonNew);
        this.add(botonEdit);
        this.add(botonDelete);
        this.add(botonExit);
    }
    
}
