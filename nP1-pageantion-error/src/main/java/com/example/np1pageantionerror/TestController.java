package com.example.np1pageantionerror;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Pageable pageable = PageRequest.of(0, 5);
//        Page<TaskDto> tasksWithComments = taskRepository.findWithPage(pageable);
        Page<Task> tasksWithComments = taskRepository.findTasksWithComments(pageable);
        return tasksWithComments.stream()
                .map(TaskDto::froms)
                .collect(Collectors.toList());
        //return tasksWithComments;
    }
}
