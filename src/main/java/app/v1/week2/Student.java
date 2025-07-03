package app.v1.week2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        if (subject != null) {
            subjects.add(subject);
        }
    }

    public List<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }

    public void viewSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No Subjects yet.");
        } else {
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println((i + 1) + ". " + subjects.get(i));
            }
        }
    }

    public void viewGPA() {
        if (subjects.isEmpty()) {
            System.out.println("No Subjects yet.");
            return;
        }

        double simpleSum = subjects.stream().mapToDouble(Subject::getGrade).sum();
        System.out.printf("Total Simple GPA: %.2f%n", simpleSum / subjects.size());

        double weightedSum = 0.0;
        int totalCredits = 0;

        for (Subject s : subjects) {
            weightedSum += s.getGrade() * s.getCredits();
            totalCredits += s.getCredits();
        }

        System.out.printf("Total Weighted GPA: %.2f%n", (totalCredits == 0 ? 0.0 : weightedSum / totalCredits));
    }

    public String getName() {
        return name;
    }
}
