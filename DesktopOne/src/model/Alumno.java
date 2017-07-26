package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alumno {
    private ConexionMysql conMysql;
    private int id;
    private String apellidos;
    private String nombres;
    private String escuela;

    public Alumno(ConexionMysql conMysql) {
        this.conMysql = conMysql;
    }
    public void getAlumnoId(String id) {
        String sql = "Select id, apellidos, nombres, escuela from alumno where id = " + id;        
        try {
            ResultSet result = conMysql.executeQuery(sql);
            if(result.next()) {
                this.id = result.getInt("id");
                this.apellidos =  result.getString("apellidos");
                this.nombres =  result.getString("nombres");
                this.escuela =  result.getString("escuela");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getId() {
        return id;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getNombres() {
        return nombres;
    }
    public String getEscuela() {
        return escuela;
    }
    
    
    
    
}
