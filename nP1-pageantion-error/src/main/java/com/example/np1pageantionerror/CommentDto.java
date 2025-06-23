package com.example.np1pageantionerror;

import lombok.Data;

@Data
public class CommentDto {
    Long id;
    String comment;

    public static CommentDto fromComment(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.id = comment.getId();
        commentDto.comment = comment.getContent();
        return commentDto;
    }
}
