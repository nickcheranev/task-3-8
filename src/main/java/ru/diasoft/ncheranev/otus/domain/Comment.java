package ru.diasoft.ncheranev.otus.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@ToString(of = {"id", "text"})
public class Comment {
    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="COMMENT_SEQ")
    private Long id;
    private String text;
}
