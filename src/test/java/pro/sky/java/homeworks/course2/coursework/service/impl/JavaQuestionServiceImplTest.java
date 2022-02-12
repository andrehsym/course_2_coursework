package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.impl.JavaQuestionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {

    @Mock
    private final JavaQuestionRepositoryImpl javaQuestionRepositoryImplMock = mock(JavaQuestionRepositoryImpl.class);

    private JavaQuestionServiceImpl out;
    private List<Question> javaQuestionList;
    private static Question question1 = new Question("integer variable types", "int short byte long");
    private static Question question2 = new Question("character variable type", "char");
    private static Question question3 = new Question("boolean type of variables", "boolean");
    private static Question question4 = new Question("popular type of lists", "arraylist");

    @BeforeEach
    public void start() {
        out = new JavaQuestionServiceImpl(javaQuestionRepositoryImplMock);
//        question1 = new Question("integer variable types", "int short byte long");
//        question2 = new Question("character variable type", "char");
//        question3 = new Question("boolean type of variables", "boolean");
//        question4 = new Question("popular type of lists", "arraylist");
        javaQuestionList = new ArrayList<>();
        javaQuestionList.add(question1);
        javaQuestionList.add(question2);
        javaQuestionList.add(question3);
        javaQuestionList.add(question4);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddRemoveTests")
    void testAdd(Question q) {
        when(javaQuestionRepositoryImplMock.remove(q)).thenReturn(q);

        assertEquals(q, out.remove(q));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForAddRemoveTests")
    void testRemove(Question q) {
        when(javaQuestionRepositoryImplMock.remove(q)).thenReturn(q);

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
        when(javaQuestionRepositoryImplMock.getAll()).thenReturn(javaQuestionList);
        List<Question> forGetAllQuestionList = new ArrayList<>();
        forGetAllQuestionList.add(question1);
        forGetAllQuestionList.add(question2);
        forGetAllQuestionList.add(question3);
        forGetAllQuestionList.add(question4);

        assertIterableEquals(forGetAllQuestionList, out.getAll());
    }

    @Test
    void testGetRandomQuestion() {
        when(javaQuestionRepositoryImplMock.getAll()).thenReturn(javaQuestionList);
        List<Question> forRandomQuestionList = new ArrayList(List.copyOf(javaQuestionList));
        Question randomQuestion = out.getRandomQuestion();

        assertTrue(forRandomQuestionList.contains(randomQuestion));
    }

//    @Test
//    void testAdd() {
//        when(javaQuestionRepositoryImplMock.add(question1)).thenReturn(question1);
//        when(javaQuestionRepositoryImplMock.add(question2)).thenReturn(question2);
//        when(javaQuestionRepositoryImplMock.add(question3)).thenReturn(question3);
//        when(javaQuestionRepositoryImplMock.add(question4)).thenReturn(question4);
//
//        assertEquals(question1, out.add(question1));
//        assertEquals(question1, out.add(question1));
//        assertEquals(question1, out.add(question1));
//        assertEquals(question1, out.add(question1));
//    }

//    @Test
//    void testRemove() {
//        when(javaQuestionRepositoryImplMock.remove(question1)).thenReturn(question1);
//        when(javaQuestionRepositoryImplMock.remove(question2)).thenReturn(question2);
//        when(javaQuestionRepositoryImplMock.remove(question3)).thenReturn(question3);
//        when(javaQuestionRepositoryImplMock.remove(question4)).thenReturn(question4);
//
//        assertEquals(question1, out.remove(question1));
//        assertEquals(question1, out.remove(question1));
//        assertEquals(question1, out.remove(question1));
//        assertEquals(question1, out.remove(question1));
//    }

}