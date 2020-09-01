package com.vinaylogics.learnadvancejava.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UrlRewriteServlet", urlPatterns = "/rewrite")
public class UrlRewriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println("<a href=\""+getServletContext().getContextPath()+"/destination?uname="+request.getParameter("uname")+"\" >Visit</a>");
    }
}
