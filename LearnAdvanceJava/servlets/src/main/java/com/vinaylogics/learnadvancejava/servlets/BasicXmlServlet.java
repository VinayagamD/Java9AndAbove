package com.vinaylogics.learnadvancejava.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.Arrays;

public class BasicXmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getServletConfig().getInitParameter("test"));
        HttpSession session = req.getSession();
        session.setAttribute("Session", "This is session info");
        resp.getWriter().println("Hello World");
        req.getParameterMap().forEach((key, values) -> {
            System.out.println("Key = "+key);
            System.out.print("Values = ");
            Arrays.asList(values).forEach(value-> System.out.print(value + "\t"));
            System.out.println();
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
