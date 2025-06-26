package com.example.interfaceimple.repository;

import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> , TestJPQLRepository, TestQueryDslRepository{

}
