package pro.sky.java.homeworks.course2.coursework.service.impl;


import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.exceptions.QuestionNotFoundException;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override //сделать приватным?
    public Question add(Question question) {
        if (question == null) {
            throw new NullPointerException();
       }
//        if (questions.contains(question)) {
//            throw new EmployeeAlreadyExistsException();
//        }
        questions.add(question);
        return question;
    }

    @Override
    public int getSizeOfQuestions() {
        return questions.size();
    }

    @Override
    public Question remove(String question, String answer) {
        Question removeQuestion = new Question(question, answer);
        return remove(removeQuestion);
    }

    @Override //сделать приватным?
    public Question remove(Question question) {
        if (question == null) {
            throw new NullPointerException();
        }
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
            throw new QuestionNotFoundException();
    }

        @Override
    public Collection<Question> getAll() {
//            List<Question> questionList = new ArrayList(List.copyOf(questions));
//            return questionList;
            return List.copyOf(questions);
    }

        @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        List<Question> forRandomQuestionList = new ArrayList(List.copyOf(questions));
//        return forRandomQuestionList.get(r.nextInt(questions.size()));
        return forRandomQuestionList.get(r.nextInt(forRandomQuestionList.size()));
        }
}
