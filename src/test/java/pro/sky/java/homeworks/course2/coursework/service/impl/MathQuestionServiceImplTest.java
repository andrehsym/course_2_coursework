package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.impl.MathQuestionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceImplTest {

    @Mock
    private final MathQuestionRepositoryImpl mathQuestionRepositoryImplMock = mock(MathQuestionRepositoryImpl.class);

    private MathQuestionServiceImpl out;
    private List<Question> mathQuestionList;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;

    @BeforeEach
    public void start() {
        out = new MathQuestionServiceImpl(mathQuestionRepositoryImplMock);
        question1 = new Question("3*3", "9");
        question2 = new Question("2/2*3", "3");
        question3 = new Question("2+2", "4");
        question4 = new Question("200-300", "-100");
        mathQuestionList = new ArrayList<>();
        mathQuestionList.add(question1);
        mathQuestionList.add(question2);
        mathQuestionList.add(question3);
        mathQuestionList.add(question4);
    }

    @Test
    void testGetRandomQuestion() {
        when(mathQuestionRepositoryImplMock.getAll()).thenReturn(mathQuestionList);
        List<Question> forRandomQuestionList = new ArrayList(List.copyOf(mathQuestionList));
        Question randomQuestion = out.getRandomQuestion();

        assertTrue(forRandomQuestionList.contains(randomQuestion));
    }
}