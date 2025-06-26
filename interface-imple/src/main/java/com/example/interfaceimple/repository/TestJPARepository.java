package com.example.interfaceimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestJPARepository extends JpaRepository<String, Integer> {

    Optional<String> findByEmail(String email);

}
