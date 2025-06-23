package com.example.np1pageantionerror;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

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
}
