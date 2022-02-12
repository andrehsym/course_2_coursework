package pro.sky.java.homeworks.course2.coursework.data.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.QuestionRepository;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionNotFoundException;

import java.util.*;

@Repository
public class JavaQuestionRepositoryImpl implements QuestionRepository {

    private Set<Question> javaQuestions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new NullPointerException();
       }
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        return remove(removeQuestion);
    }

    @Override
    public Question remove(Question question) {
        if (question == null) {
            throw new NullPointerException();
        }
        if (javaQuestions.contains(question)) {
            javaQuestions.remove(question);
            return question;
        }
            throw new QuestionNotFoundException();
    }

        @Override
    public Collection<Question> getAll() {
            return List.copyOf(javaQuestions);
    }

}
