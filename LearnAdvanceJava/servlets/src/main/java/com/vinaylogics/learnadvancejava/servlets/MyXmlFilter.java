package com.vinaylogics.learnadvancejava.servlets;


import jakarta.servlet.*;

import java.io.IOException;

public class MyXmlFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter Called before url request called for servlet");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
