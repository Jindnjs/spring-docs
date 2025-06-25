package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserCreateResponseDto create(UserCreateRequestDto dto) {
        User savedUser = userRepository.save(dto.toEntity());
        return UserCreateResponseDto.toDto(savedUser);

    }

    public UserCreateResponseDto getById(Long id) {
        User savedUser = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return UserCreateResponseDto.toDto(savedUser);
    }

    public User getUserById(Long id){
        User savedUser = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return savedUser;
    }

}
