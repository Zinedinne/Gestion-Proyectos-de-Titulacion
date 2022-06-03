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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.sistemaproyectostitulacion.dataaccess.DataBaseConnection;
import uv.fei.sistemaproyectostitulacion.domain.Profesor;

public class ProfesorDAO implements IProfesorDAO {

    public ArrayList<Profesor> obtenerPorTipoDeProfesorYClave(String tipoDeProfesor, String clave){
        ArrayList<Profesor> profesoresObtenidos = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()){
            String query = "Select * from profesor where tipoDeProfesor like ? and clave like ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, tipoDeProfesor);
            statement.setString(2, clave);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                resultSet.next();
            }else{
                String nombre = "";
                String tipoProfesor = "";
                String clavePrograma = "";
                int numeroPersonal = 0;
                do {
                    nombre = resultSet.getString("nombre");
                    tipoProfesor = resultSet.getString("tipoDeProfesor");
                    numeroPersonal = resultSet.getInt("numeroDePersonal");
                    clavePrograma = resultSet.getString("clave");
                    Profesor profesorObtenido = new Profesor();
                    profesorObtenido.setNumeroDePersonal(numeroPersonal);
                    profesorObtenido.setNombre(nombre);
                    profesorObtenido.setClaveCarrera(clavePrograma);
                    profesorObtenido.setTipoProfesor(tipoProfesor);
                    profesoresObtenidos.add(profesorObtenido);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return profesoresObtenidos;
    }

    public int obtenerNumeroPersonalPorNombre(String nombre){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int numeroPersonal = 0;
        try(Connection connection = dataBaseConnection.getConnection()){
            String query = "Select numeroDePersonal from profesor where nombre like ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1, nombre);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                numeroPersonal = 0;
            }else{
                numeroPersonal = resultSet.getInt("numeroDePersonal");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return numeroPersonal;
    }
}
