package time.tabling;

import java.util.*;
public class GreedyBuilder {

    public static List<Subjects> buildGroup(List<Subjects> pool, String newGroupName) {
        List<Subjects> sorted = new ArrayList<>(pool);
        sorted.sort(Comparator.comparingDouble(Subjects::getQualification).reversed());

        Set<String> takenSubjects = new HashSet<>();
        List<Subjects> chosen = new ArrayList<>();

        for (Subjects cand : sorted) {
            String subj = cand.getSubject();
            if (takenSubjects.contains(subj)) continue;

            boolean compatible = true;
            for (Subjects s : chosen) {
                if (ScheduleUtils.overlapsAnyDay(s, cand)) {
                    compatible = false;
                    break;
                }
            }

            if (!compatible) continue;

            chosen.add(cloneWithGroup(cand, newGroupName));
            takenSubjects.add(subj);
        }
        return chosen;
    }

    private static Subjects cloneWithGroup(Subjects src, String newGroup) {
        Subjects copy = new Subjects(src.getQualification(), src.getName(), src.getLastname(),
                                     src.getSubject(), newGroup);
        var sched = src.getSchedule();
        List<Integer> days = new ArrayList<>(sched.keySet());
        Collections.sort(days);
        for (int d : days) {
            for (int[] r : sched.get(d)) {
                String range = String.format("%04d-%04d", r[0], r[1]);
                copy.addBlock(String.valueOf(d), range);
            }
        }
        return copy;
    }
}
