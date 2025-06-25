package com.example.jpaprac;

import com.example.jpaprac.entity.Hello;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(String name, Integer age, String email) {

        String processName = name + "님";
        Integer newAge = age - 1;

        Hello hello = new Hello(processName,newAge,email);
        userRepository.save(hello);

    }

    public List<Hello> getAllUser() {
        return userRepository.findAll();
    }

    public Hello getUserById(Long id) {
        Optional<Hello> optionalUser =  userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else
            return new Hello();
    }


    public List<Hello> getUserByAge(Integer age) {
        return userRepository.findAllByAge(age);
    }

    public Hello updateName(String name, Long id) {
        // id로 유저를 가져와
        Optional<Hello> opt = userRepository.findById(id);
        if(opt.isEmpty()) {
            throw new RuntimeException("해당 유저 없음");
        }
        //id인 유저
        Hello hello = opt.get();
        // 가져온 유저의 name을 변경
        hello.setName(name);
        // 변경된유저를 다시 저장
        return userRepository.save(hello);
    }

    public void deleteName(Long id) {
        userRepository.deleteById(id);
    }
}
