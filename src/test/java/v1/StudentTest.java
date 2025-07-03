package v1;

import app.v1.week2.Student;
import app.v1.week2.Subject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testAddSubject() {
        Student student = new Student("Alice");
        Subject math = new Subject("Math");
        math.setGrade(1.3);
        math.setCredits(5);
        math.setTeacher("Dr. A");

        student.addSubject(math);
        List<Subject> subjects = student.getSubjects();

        assertEquals(1, subjects.size());
        assertEquals("Math", subjects.get(0).getTitle());
    }

    @Test
    void testEmptyGPA() {
        Student student = new Student("Bob");
        assertDoesNotThrow(student::viewGPA);
    }

    @Test
    void testGPAComputation() {
        Student student = new Student("Charlie");

        Subject s1 = new Subject("AI");
        s1.setGrade(1.0);
        s1.setCredits(6);
        s1.setTeacher("Prof. X");

        Subject s2 = new Subject("ML");
        s2.setGrade(2.0);
        s2.setCredits(4);
        s2.setTeacher("Prof. Y");

        student.addSubject(s1);
        student.addSubject(s2);

        // Verify weighted GPA
        double expectedWeightedGPA = (1.0 * 6 + 2.0 * 4) / 10.0;
        double weightedSum = student.getSubjects().stream()
                .mapToDouble(sub -> sub.getGrade() * sub.getCredits()).sum();
        int totalCredits = student.getSubjects().stream()
                .mapToInt(Subject::getCredits).sum();

        assertEquals(expectedWeightedGPA, weightedSum / totalCredits, 0.01);
    }
}
