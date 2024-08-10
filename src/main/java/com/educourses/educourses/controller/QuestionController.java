package com.educourses.educourses.controller;

import com.educourses.educourses.model.Answer;
import com.educourses.educourses.model.Question;
import com.educourses.educourses.service.AnswerService;
import com.educourses.educourses.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @GetMapping("/{uuid}")
    public ResponseEntity<Question> getQuestion(@PathVariable String uuid) {
        return questionService.getQuestionByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
