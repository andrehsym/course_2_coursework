package pro.sky.java.homeworks.course2.coursework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.QuestionRepository;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionListOutOfBoundException;
import pro.sky.java.homeworks.course2.coursework.service.ExamineService;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExamineServiceImpl implements ExamineService {

    @Qualifier("javaQuestionServiceImpl")
    private final QuestionService javaQuestionService;

    @Qualifier("mathQuestionServiceImpl")
    private final QuestionService mathQuestionService;

    @Qualifier("javaQuestionRepositoryImpl")
    private final QuestionRepository javaQuestionRepository;

    @Qualifier("mathQuestionRepositoryImpl")
    private final QuestionRepository mathQuestionRepository;

    public ExamineServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService javaQuestionService,
                              @Qualifier("mathQuestionServiceImpl") QuestionService mathQuestionService,
                              @Qualifier("javaQuestionRepositoryImpl") QuestionRepository javaQuestionRepository,
                              @Qualifier("mathQuestionRepositoryImpl") QuestionRepository mathQuestionRepository) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        this.javaQuestionRepository = javaQuestionRepository;
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public List<Question> getQuestions(int amount) {

        //Первая реализация метода - с ним в тесте невозможно выполнить проверку
//        List<Question> randomQuestionList = new ArrayList<>(List.copyOf(javaQuestionRepository.getAll()));
//        randomQuestionList.addAll(mathQuestionRepository.getAll());
//        List<Question> collectionFromRandomQuestionList = new ArrayList<>();
//        if (amount > randomQuestionList.size() || amount < 0) {
//            throw new QuestionListOutOfBoundException();
//        }
//        Random rand = new Random();
//        for (int i = 1; i < amount + 1; i++) {
//            Question add = randomQuestionList.get(rand.nextInt(randomQuestionList.size()));
//            if (!collectionFromRandomQuestionList.contains(add)) {
//                collectionFromRandomQuestionList.add(add);
//            }
//        }
//        List<Question> randomQuestionList = new ArrayList<>(List.copyOf(javaQuestionRepository.getAll()));
//        randomQuestionList.addAll(mathQuestionRepository.getAll());

        //Вторая реализация метода
        List<Question> collectionFromRandomQuestionList = new ArrayList<>();
        if (amount > javaQuestionRepository.getAll().size() + mathQuestionRepository.getAll().size() || amount < 0) {
            throw new QuestionListOutOfBoundException();
        }
        int javaRandomQuestionListSize = amount/2;
        for (int i = 1; i < javaRandomQuestionListSize + 1; i++) {
            Question addJavaRandomQuestion = javaQuestionService.getRandomQuestion();
            if (!collectionFromRandomQuestionList.contains(addJavaRandomQuestion)) {
                collectionFromRandomQuestionList.add(addJavaRandomQuestion);
            }
        }
        int mathRandomQuestionListSize = amount - javaRandomQuestionListSize;
        for (int i = 1; i < mathRandomQuestionListSize + 1; i++) {
            Question addMathRandomQuestion = mathQuestionService.getRandomQuestion();
            if (!collectionFromRandomQuestionList.contains(addMathRandomQuestion)) {
                collectionFromRandomQuestionList.add(addMathRandomQuestion);
            }
        }
        return collectionFromRandomQuestionList;
    }
}
