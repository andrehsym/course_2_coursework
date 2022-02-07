package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.impl.JavaQuestionRepositoryImpl;
import pro.sky.java.homeworks.course2.coursework.data.impl.MathQuestionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {
    @Mock
    private final JavaQuestionRepositoryImpl javaQuestionRepositoryImplMock = mock(JavaQuestionRepositoryImpl.class);

    private JavaQuestionServiceImpl out;
    private List<Question> javaQuestionList;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;

    @BeforeEach
    public void start() {
        out = new JavaQuestionServiceImpl(javaQuestionRepositoryImplMock);
        question1 = new Question("integer variable types", "int short byte long");
        question2 = new Question("character variable type", "char");
        question3 = new Question("boolean type of variables", "boolean");
        question4 = new Question("popular type of lists", "arraylist");
        javaQuestionList = new ArrayList<>();
        javaQuestionList.add(question1);
        javaQuestionList.add(question2);
        javaQuestionList.add(question3);
        javaQuestionList.add(question4);
    }

    @Test
    void testGetRandomQuestion() {
        when(javaQuestionRepositoryImplMock.getAll()).thenReturn(javaQuestionList);
        List<Question> forRandomQuestionList = new ArrayList(List.copyOf(javaQuestionList));
        Question randomQuestion = out.getRandomQuestion();

        assertTrue(forRandomQuestionList.contains(randomQuestion));
    }

}