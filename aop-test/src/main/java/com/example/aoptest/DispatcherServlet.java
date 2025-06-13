//package com.example.aoptest;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerAdapter;
//import org.springframework.web.servlet.HandlerExecutionChain;
//import org.springframework.web.servlet.ModelAndView;
//
//public class DispatcherServlet {
//    org.springframework.web.servlet.DispatcherServlet dispatcherServlet;
//
//    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) {
//        // 2. HandlerMapping을 통해 컨트롤러 찾기
//        //HandlerExecutionChain mappedHandler = getHandler(processedRequest);
//
//        // 3. HandlerAdapter 조회
//        HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
//
//        // 4. 여기서 ArgumentResolver들이 파라미터 바인딩
//        //ModelAndView mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
//    }
//}
