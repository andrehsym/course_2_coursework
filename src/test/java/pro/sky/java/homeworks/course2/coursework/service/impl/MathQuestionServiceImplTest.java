package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.impl.MathQuestionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceImplTest {

    @Mock
    private final MathQuestionRepositoryImpl mathQuestionRepositoryImplMock = mock(MathQuestionRepositoryImpl.class);

    private MathQuestionServiceImpl out;
    private List<Question> mathQuestionList;
    private static Question question1 = new Question("3*3", "9");
    private static Question question2 = new Question("2/2*3", "3");
    private static Question question3 = new Question("2+2", "4");
    private static Question question4 = new Question("200-300", "-100");

    @BeforeEach
    public void start() {
        out = new MathQuestionServiceImpl(mathQuestionRepositoryImplMock);
//        question1 = new Question("3*3", "9");
//        question2 = new Question("2/2*3", "3");
//        question3 = new Question("2+2", "4");
//        question4 = new Question("200-300", "-100");
        mathQuestionList = new ArrayList<>();
        mathQuestionList.add(question1);
        mathQuestionList.add(question2);
        mathQuestionList.add(question3);
        mathQuestionList.add(question4);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddRemoveTests")
    void testAdd(Question q) {
        when(mathQuestionRepositoryImplMock.remove(q)).thenReturn(q);

        assertEquals(q, out.remove(q));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddRemoveTests")
    void testRemove(Question q) {
        when(mathQuestionRepositoryImplMock.remove(q)).thenReturn(q);

        assertEquals(q, out.remove(q));
    }

    public static Stream<Arguments> provideParamsForAddRemoveTests() {
        return Stream.of(
                Arguments.of(question1),
                Arguments.of(question2),
                Arguments.of(question3),
                Arguments.of(question4)
        );
    }

    @Test
    void testGetAll() {
        when(mathQuestionRepositoryImplMock.getAll()).thenReturn(mathQuestionList);
        List<Question> forGetAllQuestionList = new ArrayList<>();
        forGetAllQuestionList.add(question1);
        forGetAllQuestionList.add(question2);
        forGetAllQuestionList.add(question3);
        forGetAllQuestionList.add(question4);

        assertIterableEquals(forGetAllQuestionList, out.getAll());
    }

    @Test
    void testGetRandomQuestion() {
        when(mathQuestionRepositoryImplMock.getAll()).thenReturn(mathQuestionList);
        List<Question> forRandomQuestionList = new ArrayList(List.copyOf(mathQuestionList));
        Question randomQuestion = out.getRandomQuestion();

        assertTrue(forRandomQuestionList.contains(randomQuestion));
    }
}