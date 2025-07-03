package app.v1.week2;

public class Subject {
    private String title;
    private double grade;
    private int credits;
    private String teacher;

    public Subject(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGrade(double grade) {
        if (grade < 0 || grade > 6.0) throw new IllegalArgumentException("Invalid grade");
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setCredits(int credits) {
        if (credits < 0) throw new IllegalArgumentException("Credits must be positive");
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return String.format("Title: %s | Grade: %.2f | Credits: %d | Teacher: %s",
                title, grade, credits, teacher);
    }
}
