package com.aiquizgenerator.backend.quiz.services;

import org.springframework.stereotype.Service;

import com.aiquizgenerator.backend.quiz.dto.QuizDto;
import com.aiquizgenerator.backend.quiz.entities.Quiz;
import com.aiquizgenerator.backend.quiz.factories.QuizFactory;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizService {
    
    private final QuizRepository quizRepository;

    private final QuizFactory quizFactory;

    public QuizDto create(Quiz quiz) {
        Quiz createdQuiz =  quizRepository.save(quiz);

        return quizFactory.createDto(createdQuiz);
    }
}
