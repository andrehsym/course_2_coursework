package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.impl.JavaQuestionRepositoryImpl;
import pro.sky.java.homeworks.course2.coursework.data.impl.MathQuestionRepositoryImpl;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionServiceImpl implements QuestionService {

    private final MathQuestionRepositoryImpl mathQuestionRepositoryImpl;

    public MathQuestionServiceImpl(@Qualifier("mathQuestionRepositoryImpl") MathQuestionRepositoryImpl mathQuestionRepositoryImpl) {
        this.mathQuestionRepositoryImpl = mathQuestionRepositoryImpl;
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        List<Question> forRandomQuestionList = new ArrayList(List.copyOf(mathQuestionRepositoryImpl.getAll()));
        return forRandomQuestionList.get(r.nextInt(forRandomQuestionList.size()));
    }

    @PostConstruct
    public void init() {
        mathQuestionRepositoryImpl.add(new Question("3*3", "9"));
        mathQuestionRepositoryImpl.add(new Question("2/2*3", "3"));
        mathQuestionRepositoryImpl.add(new Question("2+2", "4"));
        mathQuestionRepositoryImpl.add(new Question("200-300", "-100"));
    }
}
