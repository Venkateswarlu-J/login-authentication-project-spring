/*package com.LoginJv.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        HttpSession session=request.getSession(false);
        String path=request.getRequestURI();
        System.out.println(path);
        boolean isPublic=
                path.equals("/")
                ||path.equals("/Login")
                ||path.equals("/Register")
                ||path.equals("/ForgetPass")
                ||path.equals("/validate-OTP");
        System.out.println(isPublic);
        if(!isPublic&&(session==null || session.getAttribute("email")==null)){
            response.sendRedirect("/Login");
            return;
        }
        if (session != null && session.getAttribute("email") != null &&
                (path.equals("/Login") || path.equals("/Register"))) {
            response.sendRedirect("/Main");
            return;
        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}*/
