package ru.diasoft.ncheranev.otus.web.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CommentDto {
    private Long id;
    private String text;
}
