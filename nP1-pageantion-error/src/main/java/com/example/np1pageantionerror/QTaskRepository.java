package com.example.np1pageantionerror;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QTaskRepository {

    Page<TaskDto> findWithPage(Pageable pageable);
}
