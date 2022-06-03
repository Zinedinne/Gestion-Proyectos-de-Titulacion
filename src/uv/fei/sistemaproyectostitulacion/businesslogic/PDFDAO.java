/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uv.fei.sistemaproyectostitulacion.dataaccess.DataBaseConnection;
import uv.fei.sistemaproyectostitulacion.domain.PDF;

/**
 *
 * @author oscar
 */
public class PDFDAO implements IPDFDAO{

    public boolean agregarPDF(PDF pdfRegistrado) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = null;
        boolean registroRealizado = false;
        int columnasAfectadas = 0;
        try{
            connection = dataBaseConnection.getConnection();
            String query = "Insert into archivopdf (idProyecto, nombre, archivo) values(?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query); 
            statement.setInt(1, pdfRegistrado.getIdProyecto());
            statement.setString(2, pdfRegistrado.getNombreMatricula());
            statement.setBytes(3, pdfRegistrado.getArchivo());
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
                Logger.getLogger(PDFDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          }  
        } 
        if (columnasAfectadas > 0){
            registroRealizado = true;
        }
        return registroRealizado;   
    }
        

}
