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
        proper.load(new FileInputStream("mysql.properties"));

        String host = proper.getProperty("host");
        String port = proper.getProperty("port");
        String db = proper.getProperty("db");
        String user = proper.getProperty("user");
        String password = proper.getProperty("password");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db;

        conn = DriverManager.getConnection(url, user, password);
    }
    // Cierra las conexiones abiertas
    private void close(Connection conn, Statement state, ResultSet result) throws SQLException {
        if(conn != null)
            conn.close();
        if(state != null)
            state.close();
        if(result != null)
            result.close();
    }
    // Cierra el state y result
    public void close(Statement state, ResultSet result) throws SQLException {
        close(null, state, result);
    }
    // Cierra el state
    public void close(Statement state) throws SQLException {
        close(null, state, null);
    }
    // Cierra el result
    public void close(ResultSet result) throws SQLException {
        close(null, null, result);
    }
    // Ejecuta una consulta con un parametro de busqueda con una respuesta
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
    // Ejecuta una consulta con un parametro de busqueda con varias respuesta
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
    // Ejecuta una consulta con varios parametro de busqueda con varias respuesta
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
    // Ejecuta una consulta sin parametros
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
    // Metodo abstracto que obtiene los datos de un RecordSet y los pasa al objeto
    protected abstract Object getData(ResultSet result)  throws SQLException;

    // Obtiene el ResultSet de la consulta con un parametro
    private ResultSet getResultSet(String field, String sql) throws SQLException {
        PreparedStatement preState = conn.prepareStatement(sql);
        preState.setString(1, field);
        return preState.executeQuery();
    }
    // Obtiene el ResultSet de la consulta con varios parametros
    private ResultSet getResultSet(List<String> fields, String sql) throws SQLException {
        PreparedStatement preState = conn.prepareStatement(sql);
        for(int i = 0; i < fields.size(); i++) {
            String field = fields.get(i);
            preState.setString(i + 1, field);
        }        
        return preState.executeQuery();
    }
    // Obtiene el ResultSet de la consulta sin parametros
    private ResultSet getResultSet(String sql) throws SQLException {        
        Statement state = conn.createStatement();        
        return state.executeQuery(sql);
    }
    // Obtiene la lista de objetos del ResultSet
    private List<Object> getList(ResultSet result) throws SQLException {
        List<Object> listObject = new ArrayList<>();
        while(result.next()) {
            Object tmp = getData(result);
            listObject.add(tmp);
        }
        return listObject;
    }
    // Obtiene el objetos del ResultSet
    private Object getObject(ResultSet result) throws SQLException{
        Object tmp = null;
        if(result.next()) {
            tmp = getData(result);
        }
        return tmp;
    }
}
