package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double value = 0;
        double namSub = 0;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                value += sub.score();
                namSub++;
            }
        }
        return value > 0 ? value / namSub : 0;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        double value = 0;
        double namSub = 0;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                value += sub.score();
                namSub++;
            }
            res.add(new Label(pupil.name(), value > 0 ? value / namSub : 0));
            value = 0;
            namSub = 0;
        }
        return res;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subject = pupil.subjects();
            for (Subject sub : subject) {
                if (map.containsKey(sub.name())) {
                    map.put(sub.name(), map.get(sub.name()) + sub.score());
                } else {
                    map.put(sub.name(), sub.score());
                }
            }
        }
        List<Label> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(new Label(key, map.get(key) / pupils.size()));
        }
        return res;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        double value = 0;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                value += sub.score();
            }
            res.add(new Label(pupil.name(), value));
            value = 0;
        }
        res.sort(Comparator.naturalOrder());
        return res.get(res.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subject = pupil.subjects();
            for (Subject sub : subject) {
                if (map.containsKey(sub.name())) {
                    map.put(sub.name(), map.get(sub.name()) + sub.score());
                } else {
                    map.put(sub.name(), sub.score());
                }
            }
        }
        List<Label> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(new Label(key, map.get(key)));
        }
        res.sort(Comparator.naturalOrder());
        return res.get(res.size() - 1);
    }
}

