package com.vinaylogics.schoolmanagement.controllers;

import com.vinaylogics.schoolmanagement.dto.ResponseData;
import com.vinaylogics.schoolmanagement.models.User;
import com.vinaylogics.schoolmanagement.services.UserService;
import com.vinaylogics.schoolmanagement.services.impl.UserServiceImpl;
import com.vinaylogics.schoolmanagement.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/teachers")
public class TeachersController extends HttpServlet implements Constants.Url {
    private final UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterMap().containsKey(PAGE)){
            switch (req.getParameter(PAGE)){
                case TEACHERS:
                    getTeacherResponse(req,resp);
                    break;
                default:
                    getTeacherPage(req, resp);

            }
        }else {
            getTeacherPage(req, resp);
        }
    }


    private void getTeacherResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> users = service.getTeachers();
        getUsers(resp, users);
    }


    private void getUsers(HttpServletResponse resp, List<User> users) throws IOException {
        ResponseData<List<User>> responseData = new ResponseData<>(true, users, "Success",
                200);
        resp.setStatus(200);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(ResponseData.toJson(responseData));
        printWriter.flush();
        printWriter.close();
    }

    private void getTeacherPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/teachers/teachers.jsp");
        rd.include(req,resp);
    }
}
