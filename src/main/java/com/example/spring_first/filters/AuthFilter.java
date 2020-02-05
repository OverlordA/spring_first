package com.example.spring_first.filters;

import com.example.spring_first.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/user/*")
public class AuthFilter implements Filter {

    private final JwtService jwtService;

    @Autowired
    public AuthFilter(JwtService jwtService){
        this.jwtService = jwtService;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Auth filter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter() method is invoked");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        Boolean jwtIsValid = jwtService.validateJWT(httpServletRequest.getHeader("token"));
        System.out.println("Jwt is valid = " + jwtIsValid);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
