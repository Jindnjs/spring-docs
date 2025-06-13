package com.example.aoptest;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class CustomArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CustomRequestBody.class) &&
                parameter.getParameterType() == UserRoleChangeRequest.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        log.info("=== ArgumentResolver 실행 시작 ===");

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String body = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);

        log.info("ArgumentResolver에서 읽은 body: {}", body);

        ObjectMapper mapper = new ObjectMapper();
        UserRoleChangeRequest result = mapper.readValue(body, UserRoleChangeRequest.class);

        log.info("=== ArgumentResolver 실행 완료 ===");
        return result;
    }
}