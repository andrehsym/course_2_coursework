package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionListOutOfBoundException;
import pro.sky.java.homeworks.course2.coursework.service.ExamineService;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {

private final QuestionService questionService;

    public ExamineServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount < 0) {
//            if (amount > questionService.getSizeOfQuestions() || amount < 0) {
            throw new QuestionListOutOfBoundException();
        }
        List<Question> randomQuestionList = new ArrayList<>();
        for (int i = 1; i < amount + 1; i++) {
            Question add = questionService.getRandomQuestion();
            if (!randomQuestionList.contains(add)) {
                randomQuestionList.add(add);
            }
        }
        return randomQuestionList;
    }
}
