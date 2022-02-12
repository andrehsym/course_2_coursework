package pro.sky.java.homeworks.course2.coursework.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.service.impl.MathQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    private final MathQuestionServiceImpl mathQuestionService;

    public MathQuestionController(@Qualifier("mathQuestionServiceImpl") MathQuestionServiceImpl mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question newQuest = mathQuestionService.add(question, answer);
        return newQuest;
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question removeQuest = mathQuestionService.remove(question, answer);
        return removeQuest;
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}

