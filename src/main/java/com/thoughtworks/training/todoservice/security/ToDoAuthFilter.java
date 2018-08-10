package com.thoughtworks.training.todoservice.security;

import com.thoughtworks.training.todoservice.model.User;
import com.thoughtworks.training.todoservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
@Slf4j
@Component
public class ToDoAuthFilter extends OncePerRequestFilter {

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.info("user-Service"+request.getRequestURI());
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (null != token && !token.equals("")) {
            String[] idName = token.split(":");
            User user=new User(Integer.valueOf(idName[0]),idName[1],"","ellen");
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()));        }
        filterChain.doFilter(request, response);
    }
}
