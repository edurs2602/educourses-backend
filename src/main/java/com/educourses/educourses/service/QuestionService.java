package com.educourses.educourses.service;

import com.educourses.educourses.model.Answer;
import com.educourses.educourses.model.Question;
import com.educourses.educourses.repository.AnswerRepository;
import com.educourses.educourses.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Optional<Question> getQuestionByUuid(String uuid) {
        return questionRepository.findByUuid(uuid);
    }

    public String submitAnswer(String questionUuid, Answer answer) {
        Optional<Question> questionOptional = getQuestionByUuid(questionUuid);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            answer.setQuestion(question);
            answerRepository.save(answer);

            if (answer.getContent().equals(question.getCorrectOption())) {
                return "Correct";
            } else {
                return "Incorrect. The correct option is: " + question.getCorrectOption();
            }
        } else {
            throw new RuntimeException("Question not found");
        }
    }
}
