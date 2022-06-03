/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.domain;

/**
 *
 * @author oscar
 */
public class PDF {
    private int idProyecto;
    private String nombreMatricula;
    private byte[] archivo;

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreMatricula() {
        return nombreMatricula;
    }

    public void setNombreMatricula(String nombreMatricula) {
        this.nombreMatricula = nombreMatricula;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }
 
}
