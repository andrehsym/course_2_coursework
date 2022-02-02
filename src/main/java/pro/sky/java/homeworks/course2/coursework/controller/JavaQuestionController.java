package pro.sky.java.homeworks.course2.coursework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.service.QuestionService;

import java.util.Collection;

@RestController
//@RequestMapping("/exam/java")
@RequestMapping("/java")
public class JavaQuestionController {
//добавлять, просматривать и удалять вопросы по Java

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question newQuest = questionService.add(question, answer);
        return newQuest;
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question removeQuest = questionService.remove(question, answer);
        return removeQuest;
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
