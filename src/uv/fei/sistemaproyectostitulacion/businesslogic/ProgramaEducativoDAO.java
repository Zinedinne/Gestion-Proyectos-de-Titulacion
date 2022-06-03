/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.sistemaproyectostitulacion.dataaccess.DataBaseConnection;
import uv.fei.sistemaproyectostitulacion.domain.ProgramaEducativo;
/**
 *
 * @author oscar
 */
public class ProgramaEducativoDAO implements IProgramaEducativoDAO{

    public String obtenerClaveCarrera(String nombre){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        String clave = "";
        try(Connection connection = dataBaseConnection.getConnection()){
            String query = "Select clave from programaeducativo where nombre like ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,"%"+nombre + "%");
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                throw new SQLException("No existe este programa");
            }else{
                clave = resultSet.getString("clave");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgramaEducativoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return clave;
    }
    public ArrayList <ProgramaEducativo> obtenerProgramasEducativos(){
        ArrayList<ProgramaEducativo> programasObtenidos = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()){
            String query = "Select * from programaeducativo";
            PreparedStatement statement=connection.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                throw new SQLException("No existen programas educativos");
            }else{
                String nombre = "";
                do {
                    nombre = resultSet.getString("nombre");
                    ProgramaEducativo programaObtenido = new ProgramaEducativo();
                    programaObtenido.setNombre(nombre);
                    programasObtenidos.add(programaObtenido);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return programasObtenidos;
    }
    public ArrayList <ProgramaEducativo> obtenerProgramasEducativosPorTipo(String tipo){
        ArrayList<ProgramaEducativo> programasObtenidos = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection = dataBaseConnection.getConnection()){
            String query = "Select * from programaeducativo where tipo like ?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,"%"+tipo + "%");
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next()==false){
                throw new SQLException("No existen programas educativos");
            }else{
                String nombre = "";
                do {
                    nombre = resultSet.getString("nombre");
                    ProgramaEducativo programaObtenido = new ProgramaEducativo();
                    programaObtenido.setNombre(nombre);
                    programasObtenidos.add(programaObtenido);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return programasObtenidos;
    }
}
