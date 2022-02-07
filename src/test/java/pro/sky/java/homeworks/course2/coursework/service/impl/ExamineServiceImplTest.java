package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.QuestionRepository;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionListOutOfBoundException;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamineServiceImplTest {

    private ExamineServiceImpl out;

    @Mock
    @Qualifier("javaQuestionRepositoryImpl")
    private final QuestionRepository javaQuestionRepositoryMock = mock(QuestionRepository.class);

    @Mock
    @Qualifier("mathQuestionRepositoryImpl")
    private final QuestionRepository mathQuestionRepositoryMock = mock(QuestionRepository.class);

    @Qualifier("javaQuestionServiceImpl")
    private final QuestionService javaQuestionServiceMock = mock(JavaQuestionServiceImpl.class);

    @Qualifier("mathQuestionServiceImpl")
    private final QuestionService mathQuestionServiceMock = mock(MathQuestionServiceImpl.class);

    private List<Question> javaQuestions;
    private List<Question> mathQuestions;
    private Question javaQuestion1;
    private Question javaQuestion2;
    private Question javaQuestion3;
    private Question javaQuestion4;
    private Question mathQuestion1;
    private Question mathQuestion2;
    private Question mathQuestion3;
    private Question mathQuestion4;

    @BeforeEach
    public void start() {
        out = new ExamineServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock,
                                    javaQuestionRepositoryMock, mathQuestionRepositoryMock);
        javaQuestions = new ArrayList<>();
        javaQuestion1 = new Question("integer variable types", "int short byte long");
        javaQuestion2 = new Question("character variable type", "char");
        javaQuestion3 = new Question("boolean type of variables", "boolean");
        javaQuestion4 = new Question("popular type of lists", "arraylist");
        javaQuestions.add(javaQuestion1);
        javaQuestions.add(javaQuestion2);
        javaQuestions.add(javaQuestion3);
        javaQuestions.add(javaQuestion4);
        mathQuestions = new ArrayList<>();
        mathQuestion1 = new Question("3*3", "9");
        mathQuestion2 = new Question("2/2*3", "3");
        mathQuestion3 = new Question("2+2", "4");
        mathQuestion4 = new Question("200-300", "-100");
        mathQuestions.add(mathQuestion1);
        mathQuestions.add(mathQuestion2);
        mathQuestions.add(mathQuestion3);
        mathQuestions.add(mathQuestion4);
    }

    @Test
    void testGetQuestions() {
        when(javaQuestionRepositoryMock.getAll()).thenReturn(javaQuestions);
        when(mathQuestionRepositoryMock.getAll()).thenReturn(mathQuestions);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(javaQuestion1, javaQuestion2, javaQuestion3, javaQuestion4);
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(mathQuestion1, mathQuestion2, mathQuestion3, mathQuestion4);

        List<Question> randomQuestionTestList = new ArrayList<>();
        randomQuestionTestList.add(javaQuestion1);
        randomQuestionTestList.add(javaQuestion2);
        randomQuestionTestList.add(javaQuestion3);
        randomQuestionTestList.add(javaQuestion4);
        randomQuestionTestList.add(mathQuestion1);
        randomQuestionTestList.add(mathQuestion2);
        randomQuestionTestList.add(mathQuestion3);
        randomQuestionTestList.add(mathQuestion4);

        assertIterableEquals(randomQuestionTestList, out.getQuestions(8));
    }

    @Test
    void shouldReturnQuestionListOutOfBoundExceptionWhenAmountOutOfQuestionListSize() {
        assertThrows(QuestionListOutOfBoundException.class, () -> out.getQuestions(-1));
    }
}