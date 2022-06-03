/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.domain;

/**
 *
 * @author oscar
 */
public class ProyectoDeTitulacion {
    private String titulo;
    private String descripcion;
    private String modalidad;
    private String resultado;
    private String fechaTitulacion;
    private String claveCarrera;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFechaTitulacion() {
        return fechaTitulacion;
    }

    public void setFechaTitulacion(String fechaTitulacion) {
        this.fechaTitulacion = fechaTitulacion;
    }

    public String getClaveCarrera() {
        return claveCarrera;
    }

    public void setClaveCarrera(String claveCarrera) {
        this.claveCarrera = claveCarrera;
    }

}
