package com.aiquizgenerator.backend.quiz;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.quiz.dto.QuizDto;
import com.aiquizgenerator.backend.quiz.dto.request.CreateQuizDto;
import com.aiquizgenerator.backend.quiz.entities.Quiz;
import com.aiquizgenerator.backend.quiz.services.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    private final GeneratorService generatorService;
    
    @PostMapping
    public QuizDto createQuiz(
        @RequestBody() CreateQuizDto createQuizDto
    ) {
        Quiz generatedQuiz = generatorService.generateQuiz(createQuizDto);

        generatedQuiz.setPrompt(createQuizDto.getPrompt());

        return quizService.create(generatedQuiz);
    }
}
