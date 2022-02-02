package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionNotFoundException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {

    private JavaQuestionServiceImpl out = new JavaQuestionServiceImpl();

    private Set<Question> questions;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Question question6;

//    @Mock
//    Random r = mock(Random.class);

    @BeforeEach
    public void start() {
        question1 = new Question("integer variable types", "int short byte long");
        question2 = new Question("character variable type", "char");
        question3 = new Question("boolean type of variables", "boolean");
        question4 = new Question("popular type of lists", "arraylist");
        question5 = null;
        question6 = new Question("aaaa", "bbbb");
        questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
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
        questions.remove(question1);

        assertEquals(question1, out.remove(question1));
        assertEquals(question2, out.remove(question2));
        assertEquals(question3, out.remove(question3));
        assertEquals(question4, out.remove(question4));
    }

    @Test
    void testGetAll() {
        List<Question> actualListOfQuestions = List.copyOf(questions);

        assertIterableEquals(questions, out.getAll());
    }

    @Test
    void testGetRandomQuestion() {
        Question randomQuestion = out.getRandomQuestion();

        assertTrue(questions.contains(randomQuestion));
    }
}