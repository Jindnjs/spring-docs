package com.example.np1pageantionerror;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentDto {
    Long id;
    String comment;
    Long taskId;

    public static CommentDto fromComment(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.id = comment.getId();
        commentDto.comment = comment.getContent();
        return commentDto;
    }
    @QueryProjection
    public CommentDto(Long id, String comment, Long taskId) {
        this.id = id;
        this.comment = comment;
        this.taskId = taskId;
    }
}
