package com.javatraining.advancejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.util.Arrays;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String output;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get from test servlet");
//		req.getParameterNames().asIterator().forEachRemaining(name -> {
//			System.out.println(name);
//		});
		HttpSession session = req.getSession();
		session.setAttribute("test", "hello");
		Cookie httpCookies = new Cookie("test2", "hello2");
		resp.addCookie(httpCookies);
		req.getParameterNames().asIterator().forEachRemaining(name -> {
			Arrays.asList(req.getParameterValues(name)).forEach(System.out::println);
		});
		String html = "<a href=\"/advancedjava/ServletWithPost\"> Post Servlet</a>";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter(); 
        out.println(html); 
        out.flush(); 	
	}


	



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post from test servlet");
//		req.getParameterNames().asIterator().forEachRemaining(name -> {
//			System.out.println(name);
//		});
//		

		Scanner scanner = new Scanner(req.getInputStream());
		System.out.println(scanner.nextLine());
		req.getParameterNames().asIterator().forEachRemaining(name -> {
			Arrays.asList(req.getParameterValues(name)).forEach(System.out::println);
		});
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter(); 
        out.println(output); 
        out.flush(); 	
	}
	
	





	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do put from test servlet");
//		req.getParameterNames().asIterator().forEachRemaining(name -> {
//			System.out.println(name);
//		});
//		
		
		Scanner scanner = new Scanner(req.getInputStream());
		System.out.println(scanner.nextLine());
		req.getAttributeNames().asIterator().forEachRemaining(name -> {
			System.out.println(name);
		});
		req.getParameterNames().asIterator().forEachRemaining(name -> {
			Arrays.asList(req.getParameterValues(name)).forEach(System.out::println);
		});
	
		PrintWriter out = resp.getWriter(); 
        out.println(output); 
        out.flush(); 	
	}


	


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do delete from test servlet");
//		req.getParameterNames().asIterator().forEachRemaining(name -> {
//			System.out.println(name);
//		});
//		
		
		
		Scanner scanner = new Scanner(req.getInputStream());
		System.out.println(scanner.nextLine());
		req.getAttributeNames().asIterator().forEachRemaining(name -> {
			System.out.println(name);
		});
		req.getParameterNames().asIterator().forEachRemaining(name -> {
			Arrays.asList(req.getParameterValues(name)).forEach(System.out::println);
		});
		String html = "<a href=\"/ServletWithPost\"> Post Servlet</a>";
		PrintWriter out = resp.getWriter(); 
        out.println(output); 
        out.flush(); 	
	}





	@Override
	public void destroy() {
		System.out.println("Destroy Method called");
	}



	@Override
	public void init() throws ServletException {
		output = "Test Advance Java with servlet";
		System.out.println("Init Method called");
		System.out.println(getInitParameter("test1"));
	}



	

}
