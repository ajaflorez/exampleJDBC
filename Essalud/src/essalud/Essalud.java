package essalud;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asegurado;
import model.AseguradoDAO;
import model.DAO;

public class Essalud {

    public static void main(String[] args) {
        try {

            AseguradoDAO aseDAO = new AseguradoDAO();
            
            /*Asegurado asegurado1 = aseDAO.getAseguradoDNI("45968532");
            System.out.println(asegurado1);
            
            Asegurado asegurado2 = aseDAO.getAseguradoAuto("8001011FRMOJ006");
            System.out.println(asegurado2);*/
            
            
            
            List<Asegurado> asegurados = aseDAO.getAsegurados();
            for(Asegurado ase:asegurados) {
                System.out.println(ase);
            }
            
            /*List<Asegurado> asegurados = aseDAO.getAseguradoTipo("2");
            for(Asegurado ase:asegurados) {
                System.out.println(ase);
            }*/
            /*List<Asegurado> asegurados = aseDAO.getAseguradoApellido("FLORES", "MOROCO");
            for(Asegurado ase:asegurados) {
                System.out.println(ase);
            }*/
            
            
        } catch (Exception ex) {
            Logger.getLogger(Essalud.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
