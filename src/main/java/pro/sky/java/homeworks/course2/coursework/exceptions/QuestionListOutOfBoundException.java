package pro.sky.java.homeworks.course2.coursework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionListOutOfBoundException extends RuntimeException{
}
