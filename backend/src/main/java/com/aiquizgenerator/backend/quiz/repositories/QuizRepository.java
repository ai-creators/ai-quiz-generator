package com.aiquizgenerator.backend.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiquizgenerator.backend.quiz.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, String> {
    
}
