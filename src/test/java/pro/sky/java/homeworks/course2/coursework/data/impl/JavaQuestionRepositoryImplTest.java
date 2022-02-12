package pro.sky.java.homeworks.course2.coursework.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class JavaQuestionRepositoryImplTest {

    private JavaQuestionRepositoryImpl out = new JavaQuestionRepositoryImpl();

    private Set<Question> javaQuestions;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Question question6;

    @BeforeEach
    public void start() {
        question1 = new Question("integer variable types", "int short byte long");
        question2 = new Question("character variable type", "char");
        question3 = new Question("boolean type of variables", "boolean");
        question4 = new Question("popular type of lists", "arraylist");
        question5 = null;
        question6 = new Question("aaaa", "bbbb");
        javaQuestions = new HashSet<>();
        javaQuestions.add(question1);
        javaQuestions.add(question2);
        javaQuestions.add(question3);
        javaQuestions.add(question4);
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
        List<Question> actualListOfQuestions = List.copyOf(javaQuestions);

        assertIterableEquals(javaQuestions, out.getAll());
    }
}