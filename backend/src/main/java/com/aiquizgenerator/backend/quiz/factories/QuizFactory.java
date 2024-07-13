package com.aiquizgenerator.backend.quiz.factories;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aiquizgenerator.backend.quiz.dto.AnswerDto;
import com.aiquizgenerator.backend.quiz.dto.QuestionDto;
import com.aiquizgenerator.backend.quiz.dto.QuizDto;
import com.aiquizgenerator.backend.quiz.entities.Answer;
import com.aiquizgenerator.backend.quiz.entities.Question;
import com.aiquizgenerator.backend.quiz.entities.Quiz;

@Component
public class QuizFactory {
    public QuizDto createDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        
        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        quizDto.setPrompt(quiz.getPrompt());
        quizDto.setCreatedAt(quiz.getCreatedAt());
        quizDto.setUpdatedAt(quiz.getUpdatedAt());

        if (quizDto.getQuestions() != null) {
            quizDto.setQuestions(quiz.getQuestions().stream()
            .map(this::createQuestionDto)
            .collect(Collectors.toSet()));
        }
        
        return quizDto;
    }

    private QuestionDto createQuestionDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        
        questionDto.setId(question.getId());
        questionDto.setQuestion(question.getQuestion());
        questionDto.setAnswers(question.getAnswers().stream()
                .map(this::createAnswerDto)
                .collect(Collectors.toSet()));
        
        return questionDto;
    }

    private AnswerDto createAnswerDto(Answer answer) {
        AnswerDto answerDto = new AnswerDto();
        
        answerDto.setId(answer.getId());
        answerDto.setAnswer(answer.getAnswer());
        
        return answerDto;
    }
}
