package ru.diasoft.ncheranev.otus.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.ncheranev.otus.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
