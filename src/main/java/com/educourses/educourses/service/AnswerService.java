package com.educourses.educourses.service;

import com.educourses.educourses.model.Answer;
import com.educourses.educourses.model.Question;
import com.educourses.educourses.repository.AnswerRepository;
import com.educourses.educourses.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public Answer submitAnswer(String uuid, Answer answer) {
        Question question = questionRepository.findByUuid(uuid).orElseThrow();
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }
}