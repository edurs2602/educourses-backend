package com.educourses.educourses.service;

import com.educourses.educourses.model.Activity;
import com.educourses.educourses.model.Question;
import com.educourses.educourses.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Optional<Activity> getActivityByUuid(String uuid) {
        return activityRepository.findByUuid(uuid);
    }

    public List<Question> getRandomizedQuestions(String uuid) {
        return getActivityByUuid(uuid)
                .map(Activity::getRandomizedQuestions)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }
}
