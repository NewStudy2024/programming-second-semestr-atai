package v1;

import app.v1.week2.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    @Test
    void testGradeValidation() {
        Subject s = new Subject("Math");
        assertThrows(IllegalArgumentException.class, () -> s.setGrade(-1));
        assertThrows(IllegalArgumentException.class, () -> s.setGrade(7));
    }

    @Test
    void testCreditsValidation() {
        Subject s = new Subject("Science");
        assertThrows(IllegalArgumentException.class, () -> s.setCredits(-3));
    }

    @Test
    void testToStringFormat() {
        Subject s = new Subject("Biology");
        s.setGrade(2.3);
        s.setCredits(4);
        s.setTeacher("Dr. Smith");

        String expected = "Title: Biology | Grade: 2.30 | Credits: 4 | Teacher: Dr. Smith";
        assertEquals(expected, s.toString());
    }
}
