package com.aiquizgenerator.backend.quiz.dto;

import java.util.Set;
import lombok.Data;

@Data
public class QuestionDto {
    private Integer id;
    private String question;
    private Set<AnswerDto> answers;
}