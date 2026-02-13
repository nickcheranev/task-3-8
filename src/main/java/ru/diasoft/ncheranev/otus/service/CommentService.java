package ru.diasoft.ncheranev.otus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.diasoft.ncheranev.otus.config.IntegrationConfig;
import ru.diasoft.ncheranev.otus.web.dto.CommentDto;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final IntegrationConfig.CommentGateway commentGateway;

    public CommentDto create(CommentDto commentDto) {
        log.info("Call commentGateway.create() with comment: {}", commentDto);
        CompletableFuture<CommentDto> future = commentGateway.create(commentDto);
        try {
            commentDto = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return commentDto;
    }
}
