package ru.job4j.map.attestestion;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        var score = 0.0;
        var count = 0;
        for (var list : pupils) {
            for (var student : list.subjects()) {
                count++;
                score += student.score();
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (var list : pupils) {
            double score = 0;
            for (var student : list.subjects()) {
                score += student.score();
            }
            labels.add(new Label(list.name(), score / list.subjects().size()));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (var list : pupils) {
            for (var pupil : list.subjects()) {
                map.merge(pupil.name(), pupil.score(), Integer::sum);
            }
        }
        for (var item : map.entrySet()) {
            labels.add(new Label(item.getKey(),
                    (double) item.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (var item : pupils) {
            var score = 0;
            for (var label : item.subjects()) {
                score += label.score();
            }
            labels.add(new Label(item.name(), score));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(pupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (var item : pupils) {
            for (var label : item.subjects()) {
                map.merge(label.name(), label.score(), Integer::sum);
            }
        }
        for (var item : map.entrySet()) {
            labels.add(new Label(item.getKey(), item.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
