package com.example.intercepter.intercepter;

import com.example.intercepter.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build().toUri();

        log.info("request url : {}", url);
        boolean hasAnnotation = chechAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        // Auth 권한을 가진 요청에 대해서는 세션, 쿠키, ...을 보겠음
        if(hasAnnotation) {
            //권한 체크
            String query = uri.getQuery();
            log.info("query : {}", query);
            if(query.equals("name=test")) {
                return true;
            }
            return false;
        }

        return true;
    }

    private boolean chechAnnotation(Object handler, Class clazz) {

        // resource javascript, html, ...
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if(null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            // Auth annotation이 있을 때는 true
            return true;
        }

        return false;
    }
}
