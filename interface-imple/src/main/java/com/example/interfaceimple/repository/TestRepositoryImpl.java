package com.example.interfaceimple.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TestRepositoryImpl implements TestRepository {

    private final TestJPARepository testJPQLRepository;
    private final TestQueryDslRepository testQueryDslRepository;
    private final TestJPQLRepository jpqlRepository;

    @Override
    public int dslInt() {
        return testQueryDslRepository.dslCount();
    }

    @Override
    public Optional<String> findByEmail(String email) {
        return testJPQLRepository.findByEmail(email);
    }

    @Override
    public int jpqls() {
        return jpqlRepository.jpqls();
    }
}
