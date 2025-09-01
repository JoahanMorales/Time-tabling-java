package time.tabling;

import java.util.*;

public class TimeTabling {
    public static void main(String[] args) {
        List<Subjects> all = DataFactory.buildFromTable();

        List<String> conflicts = ScheduleUtils.validateNoClashesPerGroup(all);
        if (conflicts.isEmpty()) {
            System.out.println("Sin choques dentro de cada grupo.");
        } else {
            System.out.println("️Choques encontrados:");
            conflicts.forEach(System.out::println);
        }

        Map<String, List<Subjects>> byGroup = ScheduleUtils.groupByGroup(all);
        byGroup.forEach(ScheduleUtils::printGroupSummary);

        System.out.println("\nTop profes por grupo (desc):");
        byGroup.forEach((g, L) -> {
            System.out.println(">> " + g);
            L.stream().sorted(Comparator.comparingDouble(Subjects::getQualification).reversed())
                    .forEach(s -> System.out.printf("  %.2f — %s %s — %s%n",
                            s.getQualification(), s.getName(), s.getLastname(), s.getSubject()));
        });


        System.out.println("\nChoque INTER-grupos (ejemplo manual):");
        Subjects a = all.get(0);  // ALGORITMOS 
        Subjects b = all.get(7);  // ETICA 
        boolean inter = ScheduleUtils.overlapsAnyDay(a, b);
        System.out.println(a.getSubject() + " (" + a.getGroup() + ") vs " +
                           b.getSubject() + " (" + b.getGroup() + ") => " +
                           (inter ? "CHOQUE" : "ok"));
        
        List<Subjects> pool = DataFactory.buildFromTable();

        List<String> conflicts1 = ScheduleUtils.validateNoClashesPerGroup(pool);
        System.out.println(conflicts1.isEmpty() ? "Sin choques intra-grupo en el pool."
                                               : "Choques: " + conflicts1);

        String NEW_GROUP = "2AMX";

        List<Subjects> nuevo = GreedyBuilder.buildGroup(pool, NEW_GROUP);

        System.out.println("\n== Grupo generado: " + NEW_GROUP + " ==");
        nuevo.forEach(System.out::println);

        System.out.printf("\nScore simple: %.2f | Ponderado por minutos: %.2f%n",
                ScheduleUtils.groupScoreMean(nuevo),
                ScheduleUtils.groupScoreWeightedByMinutes(nuevo));
    }
}
