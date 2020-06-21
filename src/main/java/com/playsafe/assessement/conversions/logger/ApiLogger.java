package com.playsafe.assessement.conversions.logger;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
@Slf4j
public class ApiLogger extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestId = UUID.randomUUID().toString();
        log(request, requestId);
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        request.setAttribute("requestId", requestId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        long startTime = (Long)request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        request.setAttribute("endtime", endTime);
        long executeTime = endTime - startTime;
        request.setAttribute("timetaken", executeTime);
        log.info("requestId {}, Handle :{} , request take time: {}",request.getAttribute("requestId"), handler, executeTime);
    }

    private void log(HttpServletRequest request, String requestId) {
        log.info("requestId {}, host {}  HttpMethod: {}, URI : {}",requestId, request.getHeader("host"),
                request.getMethod(), request.getRequestURI() );
    }
}
