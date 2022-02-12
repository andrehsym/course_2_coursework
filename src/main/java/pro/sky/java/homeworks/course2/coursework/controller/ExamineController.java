package pro.sky.java.homeworks.course2.coursework.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.homeworks.course2.coursework.data.Question;
import pro.sky.java.homeworks.course2.coursework.service.ExamineService;

import java.util.List;
import java.util.Set;

@RestController
public class ExamineController {

private final ExamineService examineService;

    public ExamineController(ExamineService examineService) {
        this.examineService = examineService;
    }

@GetMapping("/get/{amount}")
    public List<Question> getQuestions(@PathVariable int amount) {
    return examineService.getQuestions(amount);
}
}
