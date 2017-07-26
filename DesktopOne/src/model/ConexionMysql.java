package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMysql {
    private Connection conexion;
    private Statement state;
    private ResultSet result;
    private String url;
    private String user;
    private String password;

    public ConexionMysql(String host, String db) {
        url = "jdbc:mysql://" + host + ":3306/" + db;
        user = "root";
        password = "mysql";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            state = conexion.createStatement();  
        }
        catch(SQLException esql) {
            esql.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }    

    public ResultSet executeQuery(String sql) {
        try {        
            return state.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public int executeUpdate(String sql) {
        try {
            return state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    
    
}
