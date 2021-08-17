package com.vinaylogics.learnadvancejava.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Scanner;

@WebServlet(name = "servletannotation", urlPatterns = "/annotations", initParams = {@WebInitParam(name = "test", value = "testname")})
public class BasicServletAnnotation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post Method is called");
        Scanner scanner = new Scanner(request.getInputStream());
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("Session"));
        response.getWriter().println("Hello World From do get");
        System.out.println(getServletConfig().getInitParameter("test"));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do Put Method called");

        Scanner scanner = new Scanner(req.getInputStream());
        while (scanner.hasNextLine())
        System.out.println(scanner.nextLine());
        doGet(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do Delete Method called");

        Scanner scanner = new Scanner(req.getInputStream());
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());

        doGet(req,resp);
    }
}
