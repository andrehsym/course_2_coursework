package pro.sky.java.homeworks.course2.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.data.QuestionRepository;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    @Qualifier("javaQuestionRepositoryImpl")
    private final QuestionRepository questionRepository;

    public JavaQuestionController(@Qualifier("javaQuestionRepositoryImpl") QuestionRepository questionRepository) {
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
