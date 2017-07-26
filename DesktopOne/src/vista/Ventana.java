package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Ventana extends JFrame{
    MainPanel panelMain;
    MainMenu menuMain; 
    FrameNew frameNew;
    MedicoFrame medicoFrame;
    
    public Ventana() throws Exception {
        super("Desktop One");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        
        menuMain = new MainMenu();
        this.setJMenuBar(menuMain);               
        
        panelMain = new MainPanel();
        this.setContentPane(panelMain);
        
        frameNew = new FrameNew();
        medicoFrame = new MedicoFrame();
        
        
        // 1 forma: crear un ActionListener desde aqui
        menuMain.itemNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                medicoFrame.setVisible(true);
            }

        });
        
        panelMain.mainTool.buttonNew.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                medicoFrame.setVisible(true);
            }
        });
        

        this.setVisible(true);
    }
    
}