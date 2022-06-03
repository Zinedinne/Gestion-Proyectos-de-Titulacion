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
import javax.swing.JOptionPane;
import uv.fei.sistemaproyectostitulacion.dataaccess.DataBaseConnection;
import uv.fei.sistemaproyectostitulacion.domain.Usuariopass;
import java.sql.ResultSet;

/**
 *
 * @author Zinedinne
 */
public class UsuariopassDAO implements IUsuariopassDAO {

    final String INSERT = "INSERT INTO usuariopass(usuario, password, idUsuario) VALUES (?,?,?)";
    final String GETONE = "SELECT usuario, password FROM usuariopass WHERE usuario = ? and password = ?";
    
    @Override
    public void insertarUsuariopass(Usuariopass usuariopass) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            PreparedStatement stat=connection.prepareStatement(INSERT);
             stat.setString(1, usuariopass.getUsuario());
             stat.setString(2, usuariopass.getPassword());
             stat.setInt(3, usuariopass.getIdUsuario());
             
            if (stat.executeUpdate() == 0){
                throw new SQLException("No se pudo ingresar");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariopassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public int consultarUsuariopass(Usuariopass usuariopass) {
        int resultado=0;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try(Connection connection=dataBaseConnection.getConnection()){
            PreparedStatement stat=connection.prepareStatement(GETONE);
             stat.setString(1, usuariopass.getUsuario());
             stat.setString(2, usuariopass.getPassword());
             ResultSet rs = stat.executeQuery(GETONE);
             JOptionPane.showMessageDialog(null, rs.toString());
             
            if (rs.next()){
                resultado=1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariopassDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        JOptionPane.showMessageDialog(null, resultado);
        return resultado;
    }
    
    
}
