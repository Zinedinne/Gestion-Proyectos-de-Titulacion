/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.sistemaproyectostitulacion.dataaccess.DataBaseConnection;
import uv.fei.sistemaproyectostitulacion.domain.Usuario;

/**
 *
 * @author Zinedinne
 */
public class UsuarioDAO implements IUsuarioDAO {

    final String INSERT = "INSERT INTO usuario(nombre, telefono, correoInstitucional, rol, tipoDePersonal) VALUES (?,?,?,?,?)";
       
    @Override
    public void insertarUsuario(Usuario usuario) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            PreparedStatement stat=connection.prepareStatement(INSERT);
             stat.setString(1, usuario.getNombre());
             stat.setString(2, usuario.getTelefono());
             stat.setString(3, usuario.getCorreoinstitucional());
             stat.setString(4, usuario.getRol());
             stat.setString(5, usuario.getTipoDePersonal());
             
            if (stat.executeUpdate() == 0){
                throw new SQLException("No se pudo ingresar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariopassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
