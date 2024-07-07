package com.aiquizgenerator.backend.quiz;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiquizgenerator.backend.quiz.dto.QuizDto;
import com.aiquizgenerator.backend.quiz.dto.request.CreateQuizDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
public class QuizController {
    
    @PostMapping
    public QuizDto createQuiz(
        @RequestBody() CreateQuizDto createQuizDto
    ) {
        return new QuizDto();
    }
}
