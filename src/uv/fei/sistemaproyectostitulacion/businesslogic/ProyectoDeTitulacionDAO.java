/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.sistemaproyectostitulacion.dataaccess.DataBaseConnection;
import uv.fei.sistemaproyectostitulacion.domain.ProyectoDeTitulacion;
/**
 *
 * @author oscar
 */
public class ProyectoDeTitulacionDAO implements IProyectoDeTitulacionDAO {
    public boolean registrarProyectoTitulacion(ProyectoDeTitulacion proyectoRegistrado){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado = false;
        int columnasAfectadas = 0;
        try{
            connection = dataBaseConnection.getConnection();
            Date dateFechaTitulacion = Date.valueOf(proyectoRegistrado.getFechaTitulacion());
            String query = "Insert into proyectodetitulación(titulo, descripcion, modalidad, resultado, fechaDeTitulacion, clave) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setString(1, proyectoRegistrado.getTitulo());
            statement.setString(2, proyectoRegistrado.getDescripcion());
            statement.setString(3, proyectoRegistrado.getModalidad());
            statement.setString(4, proyectoRegistrado.getResultado());
            statement.setDate(5, dateFechaTitulacion);
            statement.setString(6, proyectoRegistrado.getClaveCarrera());
            columnasAfectadas = statement.executeUpdate();
        }
        catch(SQLException ex){
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
                Logger.getLogger(ProyectoDeTitulacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          }  
        } 
        if (columnasAfectadas > 0){
            registroRealizado = true;
        }
        return registroRealizado;   
    }
    public boolean registrarProfesoresParticipantes(String rol, int numeroPersonal, int idProyecto){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado = false;
        int columnasAfectadas = 0;
        try{
            connection = dataBaseConnection.getConnection();
            String query = "Insert into participa(rol, numeroDePersonal, idProyecto) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setString(1, rol);
            statement.setInt(2, numeroPersonal);
            statement.setInt(3, idProyecto);
            columnasAfectadas = statement.executeUpdate();
        }
        catch(SQLException ex){
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
                Logger.getLogger(ProyectoDeTitulacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          }  
        } 
        if (columnasAfectadas > 0){
            registroRealizado = true;
        }
        return registroRealizado; 
    }
    public int obtenerIdProyecto(String título){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int idProyecto = 0;
        try(Connection connection = dataBaseConnection.getConnection()){
            String query = "Select idProyecto from proyectodetitulación where titulo like ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,"%"+título + "%");
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                throw new SQLException("No existe este proyecto");
            }else{
                idProyecto = resultSet.getInt("idProyecto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgramaEducativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return idProyecto;
    }
    public boolean buscarProyectoPorNombre(String titulo){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        boolean estudianteExistente = false;
        try(Connection connection = dataBaseConnection.getConnection()){
            String query = "Select idProyecto from proyectodetitulación where titulo like ? ";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,"%"+titulo + "%");
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                estudianteExistente = true;
            }
            else{
                estudianteExistente = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return estudianteExistente;
    }
}
