package com.example.demo.schedule;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    public ScheduleCreateResponseDto create(ScheduleCreateRequestDto dto) {

        User user = userService.getUserById(dto.getUserId());
        Schedule schedule = new Schedule(dto.getTitle(),dto.getContent(), user);
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return ScheduleCreateResponseDto.toDto(saveSchedule);
    }

    public List<ScheduleCreateResponseDto> get() {
        log.info("before get schedules");
        List<Schedule> schedules = scheduleRepository.findAll();
        log.info("after get schedules");
        List<ScheduleCreateResponseDto> dtoSchedules =
                schedules.stream().map(ScheduleCreateResponseDto::toDto).collect(Collectors.toList());
        log.info("finish get schedules");
        return dtoSchedules;
    }
}
