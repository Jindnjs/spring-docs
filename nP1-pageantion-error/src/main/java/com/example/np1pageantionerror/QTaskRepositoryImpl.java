package com.example.np1pageantionerror;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.np1pageantionerror.QComment.comment;
import static com.example.np1pageantionerror.QTask.task;

@Repository
@RequiredArgsConstructor
public class QTaskRepositoryImpl implements QTaskRepository {
    private final JPAQueryFactory jPAQueryFactory;

    @Override
    public Page<TaskDto> findWithPageWith(Pageable pageable) {
        List<TaskDto> tasks = jPAQueryFactory
                .select(
                        new QTaskDto(task.id, task.title)
                )
                .from(task)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        if(!tasks.isEmpty()) {
            List<Long> taskIds = tasks.stream()
                    .map(TaskDto::getId)
                    .collect(Collectors.toList());

            List<CommentDto> comments = jPAQueryFactory
                    .select(
                            new QCommentDto(comment.id, comment.content, comment.task.id)
                    )
                    .from(comment)
                    .where(comment.task.id.in(taskIds))
                    .fetch();
            Map<Long, List<CommentDto>> commentMap = comments.stream()
                    .collect(Collectors.groupingBy(CommentDto::getId));
            tasks.forEach(task -> {
                task.setComments(commentMap.getOrDefault(task.getId(), new ArrayList<>()));
            });
        }

        Long total = jPAQueryFactory
                .select(task.count())
                .from(task)
                .fetchOne();
        long totals = total != null ? total : 0L;

        return new PageImpl<>(tasks, pageable, totals);

    }
}
