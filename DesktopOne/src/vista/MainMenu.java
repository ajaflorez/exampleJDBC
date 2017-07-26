package vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainMenu extends JMenuBar {
    JMenu menu;
    JMenuItem itemNew;

    public MainMenu() {
        menu = new JMenu("Juego");
        
        ImageIcon iconNew = new ImageIcon(this.getClass().getResource("/icon/new.png"));        
        itemNew = new JMenuItem("Nuevo", iconNew);
        
        ImageIcon iconOpen = new ImageIcon(this.getClass().getResource("/icon/open.png"));        
        JMenuItem itemOpen = new JMenuItem("Abrir", iconOpen);
        
        ImageIcon iconSave = new ImageIcon(this.getClass().getResource("/icon/save.png"));        
        JMenuItem itemSave = new JMenuItem("Grabar", iconSave);
        
        
        ImageIcon iconExit = new ImageIcon(this.getClass().getResource("/icon/exit.png"));
        JMenuItem itemExit = new JMenuItem("Exit", iconExit);
        itemExit.setMnemonic(KeyEvent.VK_E);    // Agrega el subrayado de uan letra
        itemExit.setToolTipText("Haga click para Salir");
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        menu.add(itemNew);
        menu.add(itemOpen);
        menu.add(itemSave);
        menu.addSeparator();
        menu.add(itemExit);
        
        this.add(menu);
        
    }
        
}
