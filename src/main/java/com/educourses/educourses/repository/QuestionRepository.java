package com.educourses.educourses.repository;

import com.educourses.educourses.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByUuid(String uuid);
}

