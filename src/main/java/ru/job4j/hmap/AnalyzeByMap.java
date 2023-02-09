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
        List<Label> res = new ArrayList<>();
        double value = 0;
        double namSub = 0;
        for (int i = 0; i < pupils.get(0).subjects().size(); i++) {
            for (Pupil pupil : pupils) {
                value += pupil.subjects().get(i).score();
                namSub++;
            }
            res.add(new Label(pupils.get(0).subjects().get(i).name(), value > 0 ? value / namSub : 0));
            value = 0;
            namSub = 0;
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
        return res.get(res.size()-1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        double value = 0;
        for (int i = 0; i < pupils.get(0).subjects().size(); i++) {
            for (Pupil pupil : pupils) {
                value += pupil.subjects().get(i).score();
            }
            res.add(new Label(pupils.get(0).subjects().get(i).name(), value));
            value = 0;
        }
        res.sort(Comparator.naturalOrder());
        return res.get(res.size()-1);
    }
}
