package com.example.np1pageantionerror;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor
@Data
public class TaskDto {
    Long id;
    String title;
    List<CommentDto> comments;

    public static TaskDto froms(Task task) {
        List<CommentDto> comms = task.getComments()
                .stream()
                .map(CommentDto::fromComment)
                .collect(Collectors.toList());
        TaskDto taskDto = new TaskDto();
        taskDto.id = task.getId();
        taskDto.title = task.getTitle();
        taskDto.comments = comms;
        return taskDto;
    }

    @QueryProjection
    public TaskDto(Long id, String title) {
        this.id = id;
        this.title = title;
        this.comments = new ArrayList<>();
    }

}
