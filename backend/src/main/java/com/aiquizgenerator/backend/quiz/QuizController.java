package com.aiquizgenerator.backend.quiz;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aiquizgenerator.backend.account.entities.Account;
import com.aiquizgenerator.backend.account.services.AccountService;
import com.aiquizgenerator.backend.common.pagination.PaginationResponseDto;
import com.aiquizgenerator.backend.generator.services.GeneratorService;
import com.aiquizgenerator.backend.quiz.dto.QuizDto;
import com.aiquizgenerator.backend.quiz.dto.request.CreateQuizDto;
import com.aiquizgenerator.backend.quiz.dto.request.QuizPaginationDto;
import com.aiquizgenerator.backend.quiz.entities.Quiz;
import com.aiquizgenerator.backend.quiz.services.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;
    private final AccountService accountService;
    private final GeneratorService generatorService;

    @GetMapping
    public PaginationResponseDto<QuizDto> getQuizes(QuizPaginationDto quizPaginationDto
    ){
        return quizService.findPageable(quizPaginationDto);
    }
    
    @PostMapping
    public QuizDto createQuiz(
        @RequestBody() CreateQuizDto createQuizDto,
        @AuthenticationPrincipal Jwt jwt
    ) throws AccountNotFoundException {
        try {
            String sub = jwt.getClaimAsString("sub");
            Account account = accountService.findBySub(sub);

            Quiz generatedQuiz = generatorService.generateQuiz(createQuizDto);

            generatedQuiz.setCreatedBy(account);

            return quizService.create(generatedQuiz);
        } catch(Exception exception) {
            System.out.println("EXCEPTION: " + exception.getMessage());
            throw new AccountNotFoundException();
        }
    }
}
