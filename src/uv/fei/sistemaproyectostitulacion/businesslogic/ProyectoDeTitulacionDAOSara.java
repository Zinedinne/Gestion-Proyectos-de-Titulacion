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
import uv.fei.sistemaproyectostitulacion.domain.ProyectoDeTitulacionSara;

/**
 *
 * @author cashd
 */
public class ProyectoDeTitulacionDAOSara {
    public ArrayList<ProyectoDeTitulacionSara> consultarProyectosDeTitulacion(){
        ArrayList<ProyectoDeTitulacionSara> pTEncontrados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select pt.idproyecto, pt.titulo, e.nombre as autor, "
                    + "pt.modalidad, p.nombre as director, pt.fechadetitulacion, "
                    + "pt.clave, pE.tipo from proyectodetitulación as pt, estudiante as e, "
                    + "profesor as p, participa, programaeducativo as pE where "
                    + "pt.idproyecto = e.idproyecto and pt.idproyecto = participa.idproyecto "
                    + "and participa.numerodepersonal = p.numerodepersonal and "
                    + "participa.rol = ? and pt.clave = pE.clave;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, "Director");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Proyectos de Titulación");
            }
            else {
                String titulo = "";
                String fechaDeTitulacion = "";
                String modalidad = "";
                int idProyecto = 0;
                String nombreAutor = "";
                String nombreDirector = "";
                String claveCarrera = "";
                String grado = "";
                do {
                    idProyecto = resultSet.getInt("idProyecto");
                    titulo = resultSet.getString("titulo");
                    nombreAutor = resultSet.getString("autor");
                    modalidad = resultSet.getString("modalidad");
                    nombreDirector = resultSet.getString("director");
                    fechaDeTitulacion = resultSet.getString("fechadetitulacion");
                    claveCarrera = resultSet.getString("clave");
                    grado = resultSet.getString("tipo");
                    ProyectoDeTitulacionSara pT = new ProyectoDeTitulacionSara();
                    pT.setIdProyecto(idProyecto);
                    pT.setTitulo(titulo);
                    pT.setNombreAutor(nombreAutor);
                    pT.setModalidad(modalidad);
                    pT.setNombreDirector(nombreDirector);
                    pT.setFechaDeTitulacion(fechaDeTitulacion);
                    pT.setClaveCarrera(claveCarrera);
                    pT.setGrado(grado);
                    pTEncontrados.add(pT);
                } while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProyectoDeTitulacionDAOSara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pTEncontrados;
    }
    public ArrayList<ProyectoDeTitulacionSara> consultarProyectosDeTitulacionPorDirector(String nombre){
        ArrayList<ProyectoDeTitulacionSara> pTEncontrados = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select pt.idproyecto, pt.titulo, e.nombre as autor, "
                    + "pt.modalidad, p.nombre as director, pt.fechadetitulacion, "
                    + "pt.clave, pE.tipo from proyectodetitulación as pt, estudiante as e, "
                    + "profesor as p, participa, programaeducativo as pE where "
                    + "pt.idproyecto = e.idproyecto and pt.idproyecto = participa.idproyecto "
                    + "and participa.numerodepersonal = p.numerodepersonal and "
                    + "participa.rol = ? and pt.clave = pE.clave and p.nombre like ?;";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, "Director");
            statement.setString(2, "%"+nombre+"%");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Proyectos de Titulación");
            }
            else {
                String titulo = "";
                String fechaDeTitulacion = "";
                String modalidad = "";
                int idProyecto = 0;
                String nombreAutor = "";
                String nombreDirector = "";
                String claveCarrera = "";
                String grado = "";
                do {
                    idProyecto = resultSet.getInt("idProyecto");
                    titulo = resultSet.getString("titulo");
                    nombreAutor = resultSet.getString("autor");
                    modalidad = resultSet.getString("modalidad");
                    nombreDirector = resultSet.getString("director");
                    fechaDeTitulacion = resultSet.getString("fechadetitulacion");
                    claveCarrera = resultSet.getString("clave");
                    grado = resultSet.getString("tipo");
                    ProyectoDeTitulacionSara pT = new ProyectoDeTitulacionSara();
                    pT.setIdProyecto(idProyecto);
                    pT.setTitulo(titulo);
                    pT.setNombreAutor(nombreAutor);
                    pT.setModalidad(modalidad);
                    pT.setNombreDirector(nombreDirector);
                    pT.setFechaDeTitulacion(fechaDeTitulacion);
                    pT.setClaveCarrera(claveCarrera);
                    pT.setGrado(grado);
                    pTEncontrados.add(pT);
                } while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProyectoDeTitulacionDAOSara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pTEncontrados;
    }
    public ProyectoDeTitulacionSara consultarProyectoDeTitulacionPorTitulo(String nombre){
        ProyectoDeTitulacionSara pT = new ProyectoDeTitulacionSara();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta = "select pt.idproyecto, pt.titulo, e.nombre as autor,"
                    + " pt.modalidad, p.nombre as director, pt.fechadetitulacion, "
                    + "pt.descripcion, pE.tipo, pE.nombre, "
                    + "pt.resultado from proyectodetitulación as pt, estudiante as e, "
                    + "profesor as p, participa, programaeducativo as pE where "
                    + "pt.idproyecto = e.idproyecto and pt.idproyecto = participa.idproyecto "
                    + "and participa.numerodepersonal = p.numerodepersonal and "
                    + "participa.rol = ? and pt.clave = pE.clave and pt.titulo like ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, "Director");
            statement.setString(2, nombre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Proyectos de Titulación");
            }
            else {
                String titulo = "";
                String fechaDeTitulacion = "";
                String modalidad = "";
                int idProyecto = 0;
                String nombreAutor = "";
                String nombreDirector = "Externo";
                String claveCarrera = "";
                String grado = "";
                String descripcion = "";
                String nombrePE = "";
                String resultado = "";
                idProyecto = resultSet.getInt("idProyecto");
                titulo = resultSet.getString("titulo");
                nombreAutor = resultSet.getString("autor");
                modalidad = resultSet.getString("modalidad");
                nombreDirector = resultSet.getString("director");
                fechaDeTitulacion = resultSet.getString("fechadetitulacion");
                //claveCarrera = resultSet.getString("clave");
                descripcion = resultSet.getString("descripcion");
                grado = resultSet.getString("tipo");
                nombrePE = resultSet.getString("nombre");
                resultado = resultSet.getString("resultado");
                pT.setIdProyecto(idProyecto);
                pT.setTitulo(titulo);
                pT.setNombreAutor(nombreAutor);
                pT.setModalidad(modalidad);
                pT.setNombreDirector(nombreDirector);
                pT.setFechaDeTitulacion(fechaDeTitulacion);
                //pT.setClaveCarrera(claveCarrera);
                pT.setDescripcion(descripcion);
                pT.setGrado(grado);
                pT.setNombrePE(nombrePE);
                pT.setResultado(resultado);   
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProyectoDeTitulacionDAOSara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pT;
    }
    public ArrayList<String> consultarSinodales(int id){
        ArrayList<String>sinodales = new ArrayList<>();
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) { 
            String consulta= "select distinct nombre from profesor, participa where profesor.numerodepersonal = participa.numerodepersonal and rol = ? and idProyecto = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, "Sinodal");
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                throw new SQLException ("No se encontraron Proyectos de Titulación");
            }
            else{
                String nombre = "";
                do{
                    nombre = resultSet.getString("nombre");
                    sinodales.add(nombre);
                }
                while (resultSet.next());
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProyectoDeTitulacionDAOSara.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sinodales;
    }
}
