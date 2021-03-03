package me.mrbluesky.algorithm.coupang.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Programming2Solution {

    public String[] solution(String[] grades) {
        String[] answer = {};
        java.util.ArrayList<Grade> gradeList = new ArrayList<>();
        java.util.Map<String, Grade> gradeMap = new HashMap<>();
        Grade[] gradeArray = new Grade[grades.length];
        for(int i = 0; i < grades.length; i++) {
            gradeList.add(new Grade(i, grades[i].split(" ")[0], grades[i].split(" ")[1]));
        }
        for(Grade grade: gradeList) {
            Grade target = gradeMap.get(grade.getId());
            if(target == null) {
                gradeMap.put(grade.getId(), grade);
            } else {
                if(compares(grade, target) > 0) {
                    gradeMap.put(grade.getId(), grade);
                } else if (compares(grade, target) < 0) {
                    continue;
                }
            }
        }

        java.util.ArrayList<Grade> gradeValues = new java.util.ArrayList<>(gradeMap.values());
        Grade[] refinedGrade = new Grade[gradeValues.size()];
        for(int i = 0; i < refinedGrade.length; i++) {
            refinedGrade[i] = gradeValues.get(i);
        }

        java.util.Arrays.sort(refinedGrade, new java.util.Comparator<Grade>() {
            public int compare(Grade o1, Grade o2) {
                return compares(o2, o1);
            }
        });
        answer = new String[refinedGrade.length];
        for(int i = 0; i < refinedGrade.length; i++) {
            answer[i] = refinedGrade[i].toString();
        }
        return answer;
    }

    public int compares(Grade grade, Grade targetGrade) {
        if(compareGrade(grade.getGrade(), targetGrade.getGrade()) > 0) {
            return 1;
        } else if(compareGrade(grade.getGrade(), targetGrade.getGrade()) < 0) {
            return -1;
        } else {
            if(grade.getIndex() > targetGrade.getIndex()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public int compareGrade(String a, String b) {
        String[] grades = new String[]{"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};
        java.util.ArrayList<String> gradeList = new java.util.ArrayList<>(java.util.Arrays.asList(grades));
        if(gradeList.indexOf(a) > gradeList.indexOf(b)) {
            return 1;
        } else if (gradeList.indexOf(a) > gradeList.indexOf(b)) {
            return -1;
        } else {
            return 0;
        }
    }

}

class Grade implements Comparable{
    private int index;
    private String id;
    private String grade;
    private final ArrayList<String> grades = new ArrayList<>(Arrays.asList("A+", "A0", "A-", "B+", "B0", "B-", "C+",
                                                                                    "C0", "C-", "D+", "D0", "D-", "F"));
    public Grade(int index, String id, String grade) {
        this.index = index;
        this.id = id;
        this.grade = grade;
    }

    public int getIndex() {
        return index;
    }

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return this.id + " " + this.grade;
    }


    @Override
    public int compareTo(Object o) {
        Grade target = (Grade) o;
        int thisGradeIdx = this.grades.indexOf(this.grade);
        int targetGradeIdx = this.grades.indexOf(target.getGrade());
        if(thisGradeIdx > targetGradeIdx) {

        } else if(thisGradeIdx > targetGradeIdx) {

        } else {

        }
        return 0;
    }
}
