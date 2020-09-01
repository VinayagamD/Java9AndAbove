package com.vinaylogics.learnadvancejava.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Scanner;

@WebServlet(name = "servletannotation", urlPatterns = "/annotations", initParams = {@WebInitParam(name = "test", value = "testname")})
public class BasicServletAnnotation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post Method is called");
        Scanner scanner = new Scanner(request.getInputStream());
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());
        doGet(request,response);
    }

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
