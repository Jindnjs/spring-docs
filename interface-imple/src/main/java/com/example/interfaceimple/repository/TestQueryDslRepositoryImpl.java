package com.example.interfaceimple.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TestQueryDslRepositoryImpl implements TestQueryDslRepository {
    @Override
    public int dslCount() {
        return 1;
    }
}
