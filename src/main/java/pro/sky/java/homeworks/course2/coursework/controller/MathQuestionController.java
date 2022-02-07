package pro.sky.java.homeworks.course2.coursework.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.QuestionRepository;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    @Qualifier("mathQuestionRepositoryImpl")
    private final QuestionRepository questionRepository;

    public MathQuestionController(@Qualifier("mathQuestionRepositoryImpl") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question newQuest = questionRepository.add(question, answer);
        return newQuest;
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question removeQuest = questionRepository.remove(question, answer);
        return removeQuest;
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }
}

