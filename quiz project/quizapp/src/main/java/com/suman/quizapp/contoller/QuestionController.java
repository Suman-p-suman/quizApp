package com.suman.quizapp.contoller;

import com.suman.quizapp.model.Question;
import com.suman.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){

        return questionService.getAllQustions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getOuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);

    }
}