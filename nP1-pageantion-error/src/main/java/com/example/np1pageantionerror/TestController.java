package com.example.np1pageantionerror;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TaskRepository taskRepository;

    @GetMapping("/api/tasks")
    public List<TaskDto> getTasks() {

        List<Task> tasksWithComments = taskRepository.findTasksWithComments();
        return tasksWithComments.stream()
                .map(TaskDto::froms)
                .collect(Collectors.toList());
    }
}
