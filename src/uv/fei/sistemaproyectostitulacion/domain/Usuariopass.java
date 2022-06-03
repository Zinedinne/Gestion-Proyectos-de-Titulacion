/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uv.fei.sistemaproyectostitulacion.domain;

/**
 *
 * @author Zinedinne
 */
public class Usuariopass {
    private String usuario;
    private String password;
    private int idUsuario;

    public Usuariopass() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "usuariopass{" + "usuario=" + usuario + ", password=" + password + ", idUsuario=" + idUsuario + '}';
    }
}
