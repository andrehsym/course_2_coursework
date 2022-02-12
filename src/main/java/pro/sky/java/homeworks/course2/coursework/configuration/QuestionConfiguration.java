package pro.sky.java.homeworks.course2.coursework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.java.homeworks.course2.coursework.data.impl.JavaQuestionRepositoryImpl;
import pro.sky.java.homeworks.course2.coursework.data.impl.MathQuestionRepositoryImpl;

import javax.annotation.PostConstruct;

@Configuration
public class QuestionConfiguration {
//здесь создание новых бинов

    @Bean
    public MathQuestionRepositoryImpl mathQuestionRepositoryImpl() {
        return new MathQuestionRepositoryImpl();
    }

    @Bean
    public JavaQuestionRepositoryImpl javaQuestionRepositoryImpl() {
        return new JavaQuestionRepositoryImpl();
    }
}
