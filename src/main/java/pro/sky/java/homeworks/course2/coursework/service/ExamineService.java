package pro.sky.java.homeworks.course2.coursework.service;

import pro.sky.java.homeworks.course2.coursework.data.Question;

import java.util.List;

public interface ExamineService {

    List<Question> getQuestions(int amount);
}
