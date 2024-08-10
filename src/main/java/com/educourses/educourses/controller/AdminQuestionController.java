package com.educourses.educourses.controller;

import com.educourses.educourses.model.Activity;
import com.educourses.educourses.model.Question;
import com.educourses.educourses.service.QuestionService;
import com.educourses.educourses.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/questions")
public class AdminQuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ActivityService activityService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{activityUuid}")
    public ResponseEntity<Question> createQuestion(@PathVariable String activityUuid, @RequestBody Question question) {
        Activity activity = activityService.getActivityByUuid(activityUuid)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        question.setActivity(activity);
        Question savedQuestion = questionService.createQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }
}