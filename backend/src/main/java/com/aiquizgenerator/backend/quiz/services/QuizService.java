package com.aiquizgenerator.backend.quiz.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aiquizgenerator.backend.common.pagination.PaginationResponseDto;
import com.aiquizgenerator.backend.common.pagination.factories.PaginationFactory;
import com.aiquizgenerator.backend.quiz.dto.QuizDto;
import com.aiquizgenerator.backend.quiz.dto.request.QuizPaginationDto;
import com.aiquizgenerator.backend.quiz.entities.Quiz;
import com.aiquizgenerator.backend.quiz.factories.QuizFactory;
import com.aiquizgenerator.backend.quiz.repositories.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizFactory quizFactory;
    private final PaginationFactory paginationFactory;

    @Transactional
    public QuizDto create(Quiz quiz) {
        Quiz createdQuiz = quizRepository.save(quiz);

        return quizFactory.createDto(createdQuiz);
    }

    public PaginationResponseDto<QuizDto> findPageable(QuizPaginationDto quizPaginationDto) {
        Pageable pageable = PageRequest.of(quizPaginationDto.getPage() - 1, quizPaginationDto.getSize(), Sort.by(Sort.Direction.DESC, "createdAt"));

        Page<Quiz> quizzes = quizRepository.findByCreatedAtBefore(
            quizPaginationDto.getTimestamp(),
            pageable
        );

        Page<QuizDto> quizDtos = quizzes.map(quizFactory::createDto);
        return paginationFactory.createPaginationResponse(quizDtos);
    }
}
