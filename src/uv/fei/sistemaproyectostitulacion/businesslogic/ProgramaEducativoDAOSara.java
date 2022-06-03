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
import uv.fei.sistemaproyectostitulacion.domain.ProgramaEducativoSara;

/**
 *
 * @author cashd
 */
public class ProgramaEducativoDAOSara {
    public ArrayList<ProgramaEducativoSara> consultarProgramasEducativos(){
        ArrayList<ProgramaEducativoSara> programasEducativosEncontrados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "SELECT * from programaEducativo;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Programas Educativos");
            }
            else {
                String clave = "";
                String nombre = "";
                String grado = "";
                do {
                    clave = resultSet.getString("clave");
                    nombre = resultSet.getString("nombre");
                    grado = resultSet.getString("tipo");
                    ProgramaEducativoSara programaEducativo = new ProgramaEducativoSara();
                    programaEducativo.setClave(clave);
                    programaEducativo.setGrado(grado);
                    programaEducativo.setNombre(nombre);
                    programasEducativosEncontrados.add(programaEducativo);
                } while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProgramaEducativoDAOSara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programasEducativosEncontrados;
    }
    public ProgramaEducativoSara consultarProgramasEducativosPorNombre(String pE){
        ProgramaEducativoSara programaEducativo = new ProgramaEducativoSara();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "SELECT * from programaEducativo where nombre = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, pE);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Programas Educativos");
            }
            else {
                String clave = "";
                String nombre = "";
                String grado = "";
                do {
                    clave = resultSet.getString("clave");
                    nombre = resultSet.getString("nombre");
                    grado = resultSet.getString("tipo");
                    programaEducativo.setClave(clave);
                    programaEducativo.setGrado(grado);
                    programaEducativo.setNombre(nombre);
                } while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProgramaEducativoDAOSara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programaEducativo;
    }
    public ArrayList<ProgramaEducativoSara> consultarProgramasEducativosPorGrado(String gradoABuscar){
        ArrayList<ProgramaEducativoSara> programasEducativosEncontrados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "SELECT * from programaEducativo where tipo = ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, gradoABuscar);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Programas Educativos");
            }
            else {
                String clave = "";
                String nombre = "";
                String grado = "";
                do {
                    clave = resultSet.getString("clave");
                    nombre = resultSet.getString("nombre");
                    grado = resultSet.getString("tipo");
                    ProgramaEducativoSara programaEducativo = new ProgramaEducativoSara();
                    programaEducativo.setClave(clave);
                    programaEducativo.setGrado(grado);
                    programaEducativo.setNombre(nombre);
                    programasEducativosEncontrados.add(programaEducativo);
                } while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProgramaEducativoDAOSara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return programasEducativosEncontrados;
    }
}
