package com.example.interfaceimple.repository;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository{

    Optional<String> findByEmail(String email);

    int dslInt();

    int jpqls();

}
