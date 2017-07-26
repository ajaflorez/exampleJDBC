package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO extends DAO{

    public MedicoDAO() throws Exception {
    }

    @Override
    // Cambiar Object por el nombre de la CLASE (Objecto -> Medico)
    protected Medico getData(ResultSet result) throws SQLException {
        // Obtener todos los atributos de la clase medico del objeto "result"
        String idMedico = result.getString("idmedico");
        String paterno = result.getString("paterno");
        String materno = result.getString("materno");
        String nombres = result.getString("nombres");
        String idEspecial = result.getString("idespecial");
        
        // devolver un objeto Medico creado
        return new Medico(idMedico, paterno, materno, nombres, idEspecial);
    }
    // Metodo que devuelve un medico buscado por el ID
    public Medico getMedicoId(String idMedico) throws Exception{
        String sql = "Select * from medico where idmedico = ?"; // SQL con parametros
        return (Medico)this.prexeQueryOne(idMedico, sql);   // COnsulta de 1 solo resultado        
    }
    
    public Medico getMedicoPaterno(String paterno) throws Exception {
        String sql = "select * from medico where paterno = ?";
        return (Medico)this.prexeQueryOne(paterno, sql); // casting a la clase Medico                
    }
    
    
    
    
    
    
    
}
