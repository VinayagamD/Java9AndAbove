package com.vinaylogics.learnadvancejava.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UrlRewriteServlet", urlPatterns = "/rewrite")
public class UrlRewriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("<a href=\""+getServletContext().getContextPath()+"/destination?uname="+request.getParameter("uname")+"\" >Visit</a>");
    }
}
