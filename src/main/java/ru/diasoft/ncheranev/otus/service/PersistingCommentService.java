package ru.diasoft.ncheranev.otus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.diasoft.ncheranev.otus.domain.Comment;
import ru.diasoft.ncheranev.otus.jpa.CommentRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersistingCommentService {
    private final CommentRepository commentRepository;

    public Comment save(Comment comment) {
        log.info("Saving comment: {}", comment);
        var saved = commentRepository.save(comment);
        log.info("Saved comment: {}", saved);
        return saved;
    }
}
