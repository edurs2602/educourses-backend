package com.educourses.educourses.controller;

import com.educourses.educourses.model.Activity;
import com.educourses.educourses.model.Question;
import com.educourses.educourses.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity savedActivity = activityService.createActivity(activity);
        return ResponseEntity.ok(savedActivity);
    }

    @GetMapping("/{uuid}/questions")
    public ResponseEntity<List<Question>> getRandomizedQuestions(@PathVariable String uuid) {
        List<Question> questions = activityService.getRandomizedQuestions(uuid);
        return ResponseEntity.ok(questions);
    }
}
