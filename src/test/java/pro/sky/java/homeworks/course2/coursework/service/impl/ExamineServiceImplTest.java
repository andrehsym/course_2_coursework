package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionListOutOfBoundException;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamineServiceImplTest {

//    @InjectMocks
    private ExamineServiceImpl out;

    @Mock
    private final QuestionService questionServiceMock = mock(QuestionService.class);

    private List<Question> randomQuestions;
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;

    @BeforeEach
    public void start() {
        out = new ExamineServiceImpl(questionServiceMock);
        question1 = new Question("integer variable types", "int short byte long");
        question2 = new Question("character variable type", "char");
        question3 = new Question("boolean type of variables", "boolean");
        question4 = new Question("popular type of lists", "arraylist");
        randomQuestions = new ArrayList<>();
        randomQuestions.add(question1);
        randomQuestions.add(question2);
        randomQuestions.add(question3);
        randomQuestions.add(question4);
    }

    @Test
    void testGetQuestions() {
        when(questionServiceMock.getRandomQuestion()).thenReturn(question1, question2, question3);
        when(questionServiceMock.getSizeOfQuestions()).thenReturn(3);

        List<Question> randomQuestionTestList = new ArrayList<>();
        randomQuestionTestList.add(question1);
        randomQuestionTestList.add(question2);
        randomQuestionTestList.add(question3);

        assertIterableEquals(randomQuestionTestList, out.getQuestions(3));
    }

    @Test
    void shouldReturnQuestionListOutOfBoundExceptionWhenAmountOutOfQuestionListSize() {
        assertThrows(QuestionListOutOfBoundException.class, () -> out.getQuestions(-1));
    }
}