package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class AseguradoDAO extends DAO{
    
    public AseguradoDAO() throws Exception {        
    }
    
    public Asegurado getAseguradoAuto(String autogenerado) throws Exception{
        String sql = "select * from asegurado where autogenerado = ?";
        return (Asegurado)prexeQueryOne(autogenerado, sql);
    }
    public Asegurado getAseguradoDNI(String dni) throws Exception{
        String sql = "select * from asegurado where dni = ?";
        return (Asegurado)prexeQueryOne(dni, sql);
    }    
    public List<Asegurado> getAseguradoTipo(String tipo) throws Exception{
        String sql = "select * from asegurado where tipo = ?";
        return (List<Asegurado>)(Object)prexeQuery(tipo, sql);
    }    
    public List<Asegurado> getAsegurados() throws Exception{
        String sql = "select * from asegurado";
        return (List<Asegurado>)(Object)executeQuery(sql);
    }    
    public List<Asegurado> getAseguradoApellido(String paterno, String materno) throws Exception{
        String sql = "select * from asegurado where paterno = ? and materno = ?";
        List<String> apellido = new ArrayList<>();
        apellido.add(paterno);
        apellido.add(materno);
        return (List<Asegurado>)(Object)prexeQuery(apellido, sql);
    }    
    
    
    @Override
    protected Asegurado getData(ResultSet result) throws SQLException {
        
        String autogenerado = result.getString("autogenerado");
        String dni = result.getString("dni");
        String paterno = result.getString("paterno");
        String materno = result.getString("materno");
        String nombres = result.getString("nombres");
        String fec_nac = result.getString("fec_nac");
        String his_cli = result.getString("his_cli");
        String tipo = result.getString("tipo");
        
        return new Asegurado(autogenerado, dni, paterno, materno, nombres, fec_nac, his_cli, tipo);
    }
  
}
