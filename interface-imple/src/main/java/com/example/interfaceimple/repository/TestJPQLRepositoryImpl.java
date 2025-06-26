package com.example.interfaceimple.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TestJPQLRepositoryImpl implements TestJPQLRepository {
    @Override
    public int getInt() {
        return 0;
    }
}
