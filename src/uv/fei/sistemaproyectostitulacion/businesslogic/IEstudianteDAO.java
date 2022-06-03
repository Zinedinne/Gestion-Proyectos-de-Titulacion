/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import uv.fei.sistemaproyectostitulacion.domain.Estudiante;

/**
 *
 * @author oscar
 */
public interface IEstudianteDAO {
    public boolean registrarEstudianteNuevoConProyecto(Estudiante estudianteNuevo);
}
