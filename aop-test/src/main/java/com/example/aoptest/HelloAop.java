package com.example.aoptest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.nio.charset.StandardCharsets;

@Slf4j
@Aspect
@Component
public class HelloAop {
    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("=== AOP 시작 ===");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) request;

        String body = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
        log.info("AOP에서 읽은 body: '{}'", body);

        log.info("=== 컨트롤러 메서드 호출 ===");
        Object result = joinPoint.proceed();
        log.info("=== AOP 종료 ===");

        return result;
    }
}
