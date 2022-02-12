package pro.sky.java.homeworks.course2.coursework.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryImplTest {

    private MathQuestionRepositoryImpl out = new MathQuestionRepositoryImpl();

    private Set<Question> mathQuestions;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Question question6;

    @BeforeEach
    public void start() {
        question1 = new Question("3*3", "9");
        question2 = new Question("2/2*3", "3");
        question3 = new Question("2+2", "4");
        question4 = new Question("200-300", "-100");
        question5 = null;
        question6 = new Question("aaaa", "bbbb");
        mathQuestions = new HashSet<>();
        mathQuestions.add(question1);
        mathQuestions.add(question2);
        mathQuestions.add(question3);
        mathQuestions.add(question4);
        out.add(question1);
        out.add(question2);
        out.add(question3);
        out.add(question4);
    }


    @Test
    void shouldReturnNullPointerExceptionWhenQuestionIsNull() {
        assertThrows(NullPointerException.class, () -> out.add(question5));
    }

    @Test
    void testAdd() {
        assertEquals(question1, out.add(question1));
        assertEquals(question2, out.add(question2));
        assertEquals(question3, out.add(question3));
        assertEquals(question4, out.add(question4));
    }

    @Test
    void shouldReturnQuestionNotFoundExceptionWhenQuestionDoesNotExist() {
        assertThrows(QuestionNotFoundException.class, () -> out.remove(question6));
    }

    @Test
    void testRemove() {
        assertEquals(question1, out.remove(question1));
        assertEquals(question2, out.remove(question2));
        assertEquals(question3, out.remove(question3));
        assertEquals(question4, out.remove(question4));
    }

    @Test
    void testGetAll() {
        List<Question> actualListOfQuestions = List.copyOf(mathQuestions);

        assertIterableEquals(mathQuestions, out.getAll());
    }
}