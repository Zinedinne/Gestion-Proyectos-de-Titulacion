/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.dataaccess;

/**
 *
 * @author oscar
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elrevo
 */
public class DataBaseConnection {
    private Connection connection;
    private final String DB="jdbc:mysql://127.0.0.1/tesisfei";
    private final String USUARIO="root";
    private final String CONTRASENA="";
    
    public Connection getConnection() throws SQLException{
        connect();
        return connection;
    }
    
    private void connect() throws SQLException{
        connection=DriverManager.getConnection(DB,USUARIO,CONTRASENA);
    }
    
    public void cerrarConexion(){
        if(connection!=null){
            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}