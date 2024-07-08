package com.aiquizgenerator.backend.quiz.dto;

import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Data;

@Data
public class QuizDto {
    private String id;
    private String title;
    private String prompt;
    private Set<QuestionDto> questions;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}