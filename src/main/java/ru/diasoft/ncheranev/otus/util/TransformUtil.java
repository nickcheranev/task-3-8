package ru.diasoft.ncheranev.otus.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import ru.diasoft.ncheranev.otus.domain.Comment;
import ru.diasoft.ncheranev.otus.web.dto.CommentDto;

@UtilityClass
@Slf4j
public class TransformUtil {
    public static CommentDto toDto(Comment savedComment) {
        log.info("Map entity Comment to DTO: {}", savedComment);
        return new CommentDto()
                .setId(savedComment.getId())
                .setText(savedComment.getText());
    }

    public static Comment toEntity(CommentDto commentDto) {
        log.info("Map commentDto to Entity: {}", commentDto);
        return new Comment()
                .setText(commentDto.getText());
    }
}
