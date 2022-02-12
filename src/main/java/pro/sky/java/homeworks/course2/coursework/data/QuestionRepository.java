package pro.sky.java.homeworks.course2.coursework.data;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();
}
