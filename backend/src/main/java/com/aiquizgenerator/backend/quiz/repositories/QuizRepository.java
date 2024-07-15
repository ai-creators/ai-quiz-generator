package com.aiquizgenerator.backend.quiz.repositories;

import java.time.OffsetDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aiquizgenerator.backend.quiz.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, String> {
     Page<Quiz> findByCreatedAtBefore(OffsetDateTime timestamp, Pageable pageable);
}
