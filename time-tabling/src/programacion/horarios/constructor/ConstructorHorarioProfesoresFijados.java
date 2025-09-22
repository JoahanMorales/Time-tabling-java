package programacion.horarios.constructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import programacion.horarios.nucleo.Materia;
import programacion.horarios.nucleo.RepositorioMaterias;
import programacion.horarios.nucleo.Seleccion;

public class ConstructorHorarioProfesoresFijados extends ConstructorHorarioMaximaCobertura {
    private final Map<String, String> profesoresFijados;
    
    public ConstructorHorarioProfesoresFijados(RepositorioMaterias repositorio, String nombreGrupoObjetivo,
                                          Map<String, String> profesoresFijados) {
        super(repositorio, nombreGrupoObjetivo);
        this.profesoresFijados = profesoresFijados != null ? profesoresFijados : Map.of();
    }
    
    @Override
    public List<Seleccion> construir() {
        String mejorGrupo = repositorio.encontrarGrupoMejorCobertura();
        if (mejorGrupo == null) return List.of();
        
        Set<String> materiasRequeridas = repositorio.calcularCoberturaGrupos().get(mejorGrupo);
        
        // Separar materias fijadas y libres
        Set<String> materiasFijadas = materiasRequeridas.stream()
            .filter(profesoresFijados::containsKey)
            .collect(Collectors.toSet());
        
        Set<String> materiasLibres = materiasRequeridas.stream()
            .filter(m -> !profesoresFijados.containsKey(m))
            .collect(Collectors.toSet());
        
        // Primero asignar las fijadas
        List<Materia> elegidas = new ArrayList<>();
        List<String> gruposOrigen = new ArrayList<>();
        
        for (String materia : materiasFijadas) {
            String profesorRequerido = profesoresFijados.get(materia);
            List<Materia> opciones = repositorio.obtenerPorNombreMateria(materia);
            
            Materia coincidencia = opciones.stream()
                .filter(m -> m.obtenerProfesor().coincideCon(profesorRequerido))
                .findFirst()
                .orElse(null);
            
            if (coincidencia == null) {
                System.out.println("⚠️ No se encontró al profesor " + profesorRequerido + 
                                 " para " + materia);
                return List.of();
            }
            
            if (tieneConflicto(coincidencia, elegidas)) {
                System.out.println("⚠️ Conflicto de horario con " + profesorRequerido + 
                                 " en " + materia);
                return List.of();
            }
            
            elegidas.add(coincidencia);
            gruposOrigen.add(coincidencia.obtenerGrupo());
        }
        
        // Luego las libres con retroceso
        Map<String, List<Materia>> opcionesLibres = new HashMap<>();
        for (String materia : materiasLibres) {
            List<Materia> opts = repositorio.obtenerPorNombreMateria(materia);
            opts.sort(Comparator.reverseOrder());
            opcionesLibres.put(materia, opts);
        }
        
        List<String> libresOrdenadas = new ArrayList<>(materiasLibres);
        libresOrdenadas.sort(Comparator.comparingInt(m -> opcionesLibres.get(m).size()));
        
        if (retroceso(0, libresOrdenadas, opcionesLibres, elegidas, gruposOrigen)) {
            return crearSelecciones(elegidas, gruposOrigen);
        }
        
        return List.of();
    }
    
    private boolean tieneConflicto(Materia candidata, List<Materia> elegidas) {
        for (Materia m : elegidas) {
            if (m.tieneConflictoCon(candidata)) {
                return true;
            }
        }
        return false;
    }
}