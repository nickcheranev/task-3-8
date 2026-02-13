package ru.diasoft.ncheranev.otus.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.ncheranev.otus.service.CommentService;
import ru.diasoft.ncheranev.otus.web.dto.CommentDto;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentDto commentDto) {
        log.info("Received comment: {}", commentDto);
        var savedComment = commentService.create(commentDto);
        log.info("Saved comment: {}", savedComment);
        return ResponseEntity.ok(savedComment.toString());
    }
}
