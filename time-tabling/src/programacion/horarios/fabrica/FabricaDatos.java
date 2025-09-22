package programacion.horarios.fabrica;

import java.util.ArrayList;
import java.util.List;
import programacion.horarios.nucleo.Materia;
import programacion.horarios.nucleo.Profesor;
import programacion.horarios.nucleo.RepositorioMaterias;

public class FabricaDatos {
    
    public static RepositorioMaterias crearRepositorioPorDefecto() {
        List<Materia> materias = new ArrayList<>();
        
        // Grupo 3BM1
        materias.add(crearMateria(8.4, "Sandra", "Diaz Santiago",
            "ANÁLISIS Y DISEÑO DE ALGORITMOS", "3BM1",
            new Bloque("14", "1030-1200"),
            new Bloque("2", "0830-1000")));
        
        materias.add(crearMateria(7.4, "Jose", "Sanchez Juarez",
            "PARADIGMAS DE PROGRAMACIÓN", "3BM1",
            new Bloque("134", "1200-1330")));
        
        materias.add(crearMateria(8.6, "Juan Manuel", "Carballo Jimenez",
            "ECUACIONES DIFERENCIALES", "3BM1",
            new Bloque("235", "1030-1200")));
        
        materias.add(crearMateria(6.7, "Erika", "Hernandez Rubio",
            "BASES DE DATOS", "3BM1",
            new Bloque("235", "0700-0830")));
        
        materias.add(crearMateria(5.6, "Alexis", "Testa Nava",
            "DISEÑO DE SISTEMAS DIGITALES", "3BM1",
            new Bloque("14", "0700-0830"),
            new Bloque("5", "0830-1000")));
        
        materias.add(crearMateria(8.0, "Gisela", "Gonzalez Albarran",
            "LIDERAZGO PERSONAL", "3BM1",
            new Bloque("134", "0830-1000")));
        
        // Grupo 3BM2
        materias.add(crearMateria(8.8, "Miguel Angel", "Rodriguez Castillo",
            "ANÁLISIS Y DISEÑO DE ALGORITMOS", "3BM2",
            new Bloque("134", "0830-1000")));
        
        materias.add(crearMateria(6.7, "Erika", "Hernandez Rubio",
            "BASES DE DATOS", "3BM2",
            new Bloque("235", "1030-1200")));
        
        materias.add(crearMateria(9.0, "Andrés", "Cortés Dávalos",
            "PARADIGMAS DE PROGRAMACIÓN", "3BM2",
            new Bloque("14", "0700-0830"),
            new Bloque("5", "0830-1000")));
        
        materias.add(crearMateria(6.2, "Jorge Alberto", "Cruz Rojas",
            "ECUACIONES DIFERENCIALES", "3BM2",
            new Bloque("134", "1200-1330")));
        
        materias.add(crearMateria(8.0, "Jose Juan", "Perez Perez",
            "DISEÑO DE SISTEMAS DIGITALES", "3BM2",
            new Bloque("235", "0700-0830")));
        
        materias.add(crearMateria(8.5, "Elia Tzindejhe", "Ramirez Martinez",
            "LIDERAZGO PERSONAL", "3BM2",
            new Bloque("14", "1030-1200"),
            new Bloque("2", "0830-1000")));
        
        return new RepositorioMaterias(materias);
    }
    private static Materia crearMateria(double calificacion, String nombre, String apellido,
                                        String nombreMateria, String grupo, Bloque... bloques) {
        Profesor profesor = new Profesor(nombre, apellido, calificacion);
        Materia materia = new Materia(profesor, nombreMateria, grupo);
        
        for (Bloque b : bloques) {
            materia.agregarBloqueHorario(b.digitosDias, b.rangos);
        }
        
        return materia;
    }
    
    private static class Bloque {
        final String digitosDias;
        final String[] rangos;
        
        Bloque(String digitosDias, String... rangos) {
            this.digitosDias = digitosDias;
            this.rangos = rangos;
        }
    }
}