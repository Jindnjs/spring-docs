package com.sparta.test_code.unit.service;

import com.sparta.test_code.dto.UserCreationDto;
import com.sparta.test_code.dto.UserResponseDto;
import com.sparta.test_code.entity.User;
import com.sparta.test_code.respository.UserRepository;
import com.sparta.test_code.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void 유저_서비스_단위_테스트(){

        //given
        UserCreationDto userCreationDto = new UserCreationDto("name", "email", "password");
        User user = new User("name", "email", "password");

        when(userRepository.save(any(User.class))).thenReturn(user);

        //when
        UserResponseDto result = userService.saveUser(userCreationDto);

        //then

        //상태 검증 -> 데이터가 정상적인지
        assertThat(result.getName()).isEqualTo("name");
        assertEquals("email", result.getEmail());
        //행위 검증 -> 사용된 목 객체가 진짜 사용되었는가?
        verify(userRepository, times(1)).save(any(User.class));
    }
}
