package com.example.jpaprac;

import com.example.jpaprac.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Hello, Long> {
    //User
    List<Hello> findAllByAge(Integer age);

}
