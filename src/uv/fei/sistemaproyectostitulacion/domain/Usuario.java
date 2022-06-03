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
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String telefono;
    private String correoinstitucional;
    private String rol;
    private String tipoDePersonal;

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoinstitucional() {
        return correoinstitucional;
    }

    public void setCorreoinstitucional(String correoinstitucional) {
        this.correoinstitucional = correoinstitucional;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipoDePersonal() {
        return tipoDePersonal;
    }

    public void setTipoDePersonal(String tipoDePersonal) {
        this.tipoDePersonal = tipoDePersonal;
    }

    @Override
    public String toString() {
        return "usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", correoinstitucional=" + correoinstitucional + ", rol=" + rol + ", tipoDePersonal=" + tipoDePersonal + '}';
    }
}
