/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import uv.fei.sistemaproyectostitulacion.domain.Usuariopass;

/**
 *
 * @author Zinedinne
 */
public interface IUsuariopassDAO {
    void insertarUsuariopass(Usuariopass usuariopass);
    int consultarUsuariopass(Usuariopass usuariopass);
}


