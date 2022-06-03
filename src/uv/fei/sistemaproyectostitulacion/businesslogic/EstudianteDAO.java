/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

/**
 *
 * @author oscar
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.sistemaproyectostitulacion.dataaccess.DataBaseConnection;
import uv.fei.sistemaproyectostitulacion.domain.Estudiante;

public class EstudianteDAO implements IEstudianteDAO {

    
    public boolean registrarEstudianteNuevoConProyecto(Estudiante estudianteNuevo){
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado = false;
        int columnasAfectadas = 0;
        try{
            connection = dataBaseConnection.getConnection();
            String query = "Insert into estudiante(nombre, matricula, clave, idProyecto) values (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setString(1,estudianteNuevo.getNombre());
            statement.setString(2,estudianteNuevo.getMatricula());
            statement.setString(3,estudianteNuevo.getClave());
            statement.setInt(4,estudianteNuevo.getIdProyecto());
            columnasAfectadas = statement.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
          if(connection != null){
            try{
                if(!connection.isClosed()){
                  connection.close();
                }
            }
            catch (SQLException ex){
                Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          }  
        } 
        if (columnasAfectadas > 0){
            registroRealizado = true;
        }

        return registroRealizado;
    }


}
