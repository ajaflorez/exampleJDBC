package desktopone;


import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Ventana;

public class DesktopOne {
   
    public static void main(String[] args) {
        try {
            Ventana ven = new Ventana();
            
            ven.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(DesktopOne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
