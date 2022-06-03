/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uv.fei.sistemaproyectostitulacion.businesslogic;

import java.util.ArrayList;
import uv.fei.sistemaproyectostitulacion.domain.Profesor;

/**
 *
 * @author oscar
 */
public interface IProfesorDAO {
    public ArrayList<Profesor> obtenerPorTipoDeProfesorYClave(String tipoDeProfesor, String clave);
    public int obtenerNumeroPersonalPorNombre(String nombre);
}
