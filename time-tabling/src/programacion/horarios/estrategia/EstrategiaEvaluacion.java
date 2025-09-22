/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion.horarios.estrategia;

import java.util.List;
import programacion.horarios.nucleo.Materia;

/**
 *
 * @author chump
 */
public interface EstrategiaEvaluacion {
    double evaluar(List<Materia> materias);
    String obtenerNombreEstrategia();
}
