/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import java.util.ArrayList;
import uv.fei.sistemaproyectostitulacion.domain.ProgramaEducativo;

/**
 *
 * @author oscar
 */
public interface IProgramaEducativoDAO {
    public String obtenerClaveCarrera(String nombre);
    public ArrayList <ProgramaEducativo> obtenerProgramasEducativos();
    public ArrayList <ProgramaEducativo> obtenerProgramasEducativosPorTipo(String tipo);
}
