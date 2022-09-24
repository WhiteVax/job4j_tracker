package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод вычисляет общий средний балл
     *
     * @param stream поток студентов с их списком предметов
     * @return возвращает средний бал по предметам
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.subjects()
                        .stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0.0);
    }

    /**
     * Метод вычисляет средний бал по каждому ученику
     *
     * @param stream поток студентов с их списком предметов
     * @return возвращает список учеников с их средним баллом
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects()
                                .stream()
                                .mapToInt(Subject::score)
                                .average()
                                .orElse(0.0)))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет средний бал по каждому предмету
     *
     * @param stream поток студентов с их списком предметов
     * @return возвращает список предметов с их средним баллом
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::score)))
                .entrySet().stream()
                .map(sub -> new Tuple(sub.getKey(), sub.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Возвращает лучшего ученика
     *
     * @param stream поток студентов с их списком предметов
     * @return возвращает лучшего ученика с его суммарным баллом
     * по всем предметам
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.name(),
                        pupil.subjects()
                                .stream()
                                .mapToInt(Subject::score)
                                .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }

    /**
     * Возвращает предмет с наибольшим кол-вом суммарных баллов
     * среди всех учеников
     *
     * @param stream поток студентов с их списком предметов
     * @return возвращает предмет с его суммарным баллом
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(subject -> subject.subjects().stream()
                        .map(sub -> new Tuple(sub.name(), sub.score())))
                .collect(Collectors.groupingBy(Tuple::name,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Tuple::score)))
                .entrySet()
                .stream()
                .map(el -> new Tuple(el.getKey(), el.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(null);
    }
}
