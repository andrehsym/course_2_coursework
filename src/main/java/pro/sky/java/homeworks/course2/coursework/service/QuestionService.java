package pro.sky.java.homeworks.course2.coursework.service;

import pro.sky.java.homeworks.course2.coursework.data.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    int getSizeOfQuestions();

    Question remove(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
