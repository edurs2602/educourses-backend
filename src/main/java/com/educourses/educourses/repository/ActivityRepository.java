package com.educourses.educourses.repository;

import com.educourses.educourses.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Optional<Activity> findByUuid(String uuid);
}

