package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionListOutOfBoundException;
import pro.sky.java.homeworks.course2.coursework.service.ExamineService;

import java.util.*;

@Service
public class ExamineServiceImpl implements ExamineService {

    private final JavaQuestionServiceImpl javaQuestionService;

    private final MathQuestionServiceImpl mathQuestionService;

    public ExamineServiceImpl(@Qualifier("javaQuestionServiceImpl") JavaQuestionServiceImpl javaQuestionService,
                              @Qualifier("mathQuestionServiceImpl") MathQuestionServiceImpl mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {

        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size() || amount < 0) {
            throw new QuestionListOutOfBoundException();
        }
        List<Question> randomQuestionList = new ArrayList<>(List.copyOf(javaQuestionService.getAll()));
        randomQuestionList.addAll(mathQuestionService.getAll());
        Random r = new Random();
        List<Question> collectionFromRandomQuestionList = new ArrayList<>();
        while (collectionFromRandomQuestionList.size() < amount) {
            Question add = randomQuestionList.get(r.nextInt(randomQuestionList.size()));
            if (!collectionFromRandomQuestionList.contains(add)) {
                collectionFromRandomQuestionList.add(add);
            }
        }


        return collectionFromRandomQuestionList;
    }
}