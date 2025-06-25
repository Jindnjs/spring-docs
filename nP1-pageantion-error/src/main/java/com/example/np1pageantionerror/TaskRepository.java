package com.example.np1pageantionerror;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, QTaskRepository {
    @Query("SELECT t FROM Task t left JOIN FETCH t.comments")
    Page<Task> findTasksWithComments(Pageable pageable);

    @Query("SELECT t FROM Task t left JOIN FETCH t.comments")
    List<Task> findTasksWithComments();
}