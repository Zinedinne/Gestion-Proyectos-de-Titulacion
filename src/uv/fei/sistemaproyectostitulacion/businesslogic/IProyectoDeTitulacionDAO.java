/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import uv.fei.sistemaproyectostitulacion.domain.ProyectoDeTitulacion;

/**
 *
 * @author oscar
 */
public interface IProyectoDeTitulacionDAO {
    public boolean registrarProyectoTitulacion(ProyectoDeTitulacion proyectoRegistrado);
    public boolean registrarProfesoresParticipantes(String rol, int numeroPersonal, int idProyecto);
    public int obtenerIdProyecto(String título);
    public boolean buscarProyectoPorNombre(String titulo);
}
