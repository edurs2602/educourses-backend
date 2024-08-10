package com.educourses.educourses.controller;

import com.educourses.educourses.model.Answer;
import com.educourses.educourses.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class AnswerController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/{questionUuid}/answers")
    public ResponseEntity<String> submitAnswer(@PathVariable String questionUuid, @RequestBody Answer answer) {
        String result = questionService.submitAnswer(questionUuid, answer);
        return ResponseEntity.ok(result);
    }
}
