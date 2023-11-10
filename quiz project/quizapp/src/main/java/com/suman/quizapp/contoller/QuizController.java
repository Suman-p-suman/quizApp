package com.suman.quizapp.contoller;

import com.suman.quizapp.model.Question;
import com.suman.quizapp.model.QuestionWrapper;
import com.suman.quizapp.model.Quiz;
import com.suman.quizapp.model.Responses;
import com.suman.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    ResponseEntity<String > createQuestion(@RequestParam String category,@RequestParam Integer numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
    return quizService.getQuizQuestion(id);
    }
    @PostMapping("submit/{id}")
    ResponseEntity<Integer> submitQuize(@PathVariable Integer id,@RequestBody List<Responses> response){
        return quizService.calculateResult(id,response);
    }
}
