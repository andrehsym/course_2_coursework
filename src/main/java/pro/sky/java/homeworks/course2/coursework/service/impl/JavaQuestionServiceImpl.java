package pro.sky.java.homeworks.course2.coursework.service.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.coursework.data.impl.JavaQuestionRepositoryImpl;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionNotFoundException;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final JavaQuestionRepositoryImpl javaQuestionRepositoryImpl;

    public JavaQuestionServiceImpl(@Qualifier("javaQuestionRepositoryImpl") JavaQuestionRepositoryImpl javaQuestionRepositoryImpl) {
        this.javaQuestionRepositoryImpl = javaQuestionRepositoryImpl;
    }

    public Question add(String question, String answer) {
        return javaQuestionRepositoryImpl.add(question, answer);
    }

    public Question add(Question question) {
        return javaQuestionRepositoryImpl.add(question);
    }

    public Question remove(String question, String answer) {
        return javaQuestionRepositoryImpl.remove(question, answer);
    }

    public Question remove(Question question) {
        return javaQuestionRepositoryImpl.remove(question);
    }

    public Collection<Question> getAll() {
        return javaQuestionRepositoryImpl.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        List<Question> forRandomQuestionList = new ArrayList(List.copyOf(javaQuestionRepositoryImpl.getAll()));
        return forRandomQuestionList.get(r.nextInt(forRandomQuestionList.size()));
        }

    @PostConstruct
    public void init() {
        javaQuestionRepositoryImpl.add(new Question("integer variable types", "int short byte long"));
        javaQuestionRepositoryImpl.add(new Question("character variable type", "char"));
        javaQuestionRepositoryImpl.add(new Question("boolean type of variables", "boolean"));
        javaQuestionRepositoryImpl.add(new Question("popular type of lists", "arraylist"));
    }
}
