package com.example.jpaprac;

import com.example.jpaprac.entity.Hello;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api")
    public void createUser(){

        String name = "김철수";
        String email = "asdf@asdf";
        Integer age = 18;

        userService.create(name, age , email);
    }

    @GetMapping("/api2")
    public void readUser(){
        List<Hello> hellos;
        //users = 디비에서 가져오면됨
        hellos = userService.getAllUser();
        for (Hello hello : hellos) {
            System.out.println(hello.toString());
        }
    }

    @GetMapping("/api3")
    public void readUser2(){
        Long id = 10L;
        //아이디가 id인 유저를 불러올것
        Hello hello = userService.getUserById(id);
        //user에 아이디가 2번인 유저를 넣으면됨
        System.out.println(hello);
    }

    @GetMapping("/api4")
    public void readUser3(){
        //나이로 검색해주세요
        Integer age = 190;

        List<Hello> hello = userService.getUserByAge(age);
        System.out.println(hello);
    }

    @GetMapping("/api5")
    public void readUser4(){
        //이름 변경 요청이 들어옴...!!
        String name = "Alice";
        Long id = 1L;

        Hello hello = userService.updateName(name,id);

    }


}





