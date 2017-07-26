package model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class DAO {

    private Connection conn = null;    
    
    public DAO() throws Exception{

        Properties proper = new Properties();
        // mysql.properties almacena los atributos para la conexion a Mysql
        proper.load(new FileInputStream("mysql.properties"));

        String host = proper.getProperty("host");
        String port = proper.getProperty("port");
        String db = proper.getProperty("db");
        String user = proper.getProperty("user");
        String password = proper.getProperty("password");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;
        // se obtiene la conexion de acuerdo a los parametros
        conn = DriverManager.getConnection(url, user, password);
    }
    // Cierra todas las conexiones abiertas
    private void close(Connection conn, Statement state, ResultSet result) throws SQLException {
        if(conn != null)
            conn.close();
        if(state != null)
            state.close();
        if(result != null)
            result.close();
    }
    // Cierra las conexione de state y result
    public void close(Statement state, ResultSet result) throws SQLException {
        close(null, state, result);
    }
    // Cierra la conexion de state
    public void close(Statement state) throws SQLException {
        close(null, state, null);
    }
    // Cierra la conexion de result
    public void close(ResultSet result) throws SQLException {
        close(null, null, result);
    }
    /**
     * Realiza una consulta con un parametro, y el resultado es solo un objeto
     * @param field el campo a buscar
     * @param sql la consulta a realizar
     * @return  retorma el objeto buscado y hacer el siguiente casting (Clase)
     * @throws Exception 
     */
    protected Object prexeQueryOne(String field, String sql) throws Exception{
        ResultSet result = null;
        Object tmp = null;        
        try {            
            result = getResultSet(field, sql);
            tmp = getObject(result);
            
        } finally {
            close(result);
        }        
        return tmp;
    }
    /**
     * Realiza una consulta con un parametro, y el resultado son varios objetos
     * @param field el campo a buscar
     * @param sql la consulta a realizar
     * @return retorma los objeto buscados y hacer el siguiente casting (List<Clase>)(Object)
     * @throws Exception 
     */
    protected List<Object> prexeQuery(String field, String sql) throws Exception {
        ResultSet result = null;
        List<Object> listObject = new ArrayList<>();
        try {
            result = getResultSet(field, sql);
            listObject = getList(result);            
        } finally {
            close(result);
        }
        return listObject;
    }
    /**
     * Realiza una consulta con una lista de parametros, y el resultado son varios objetos
     * @param fields la lista de campo a buscar
     * @param sql la consulta a realizar
     * @return retorna los objeto buscados y hacer el siguiente casting (List<Clase>)(Object)
     * @throws Exception 
     */
    protected List<Object> prexeQuery(List<String> fields, String sql) throws Exception {
        ResultSet result = null;
        List<Object> listObject = new ArrayList<>();
        try {
            result = getResultSet(fields, sql);
            listObject = getList(result);
        } finally {
            close(result);
        }
        return listObject;
    }
    /**
     * Realiza una consulta sin parametros, y el resultado son varios objetos
     * @param sql la consulta a realizar
     * @return retorna los objeto buscados y hacer el siguiente casting (List<Clase>)(Object)
     * @throws Exception 
     */
    protected List<Object> executeQuery(String sql) throws Exception {
        ResultSet result = null;
        List<Object> listObject = new ArrayList<>();
        try {
            result = getResultSet(sql);
            listObject = getList(result);
        } finally {
            close(result);
        }
        return listObject;
    }
    
    protected abstract Object getData(ResultSet result)  throws SQLException;

    private ResultSet getResultSet(String field, String sql) throws SQLException {
        PreparedStatement preState = conn.prepareStatement(sql);
        preState.setString(1, field);
        return preState.executeQuery();
    }
    private ResultSet getResultSet(List<String> fields, String sql) throws SQLException {
        PreparedStatement preState = conn.prepareStatement(sql);
        for(int i = 0; i < fields.size(); i++) {
            String field = fields.get(i);
            preState.setString(i + 1, field);
        }        
        return preState.executeQuery();
    }
    private ResultSet getResultSet(String sql) throws SQLException {        
        Statement state = conn.createStatement();        
        return state.executeQuery(sql);
    }

    private List<Object> getList(ResultSet result) throws SQLException {
        List<Object> listObject = new ArrayList<>();
        while(result.next()) {
            Object tmp = getData(result);
            listObject.add(tmp);
        }
        return listObject;
    }

    private Object getObject(ResultSet result) throws SQLException{
        Object tmp = null;
        if(result.next()) {
            tmp = getData(result);
        }
        return tmp;
    }
    
}
