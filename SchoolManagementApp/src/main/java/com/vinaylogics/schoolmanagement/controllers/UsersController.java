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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/users")
public class UsersController extends HttpServlet implements Constants.Url {
    private final UserService service = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameterMap().containsKey(SOURCE)) {
            switch (req.getParameter(SOURCE)) {
                case STUDENTS:
                    if (req.getParameterMap().containsKey(ID)) {
                        getStudentResponse(req, resp, Long.parseLong(req.getParameter(ID)));
                    } else {
                        getStudentsResponse(req, resp);
                    }
                    break;
                case TEACHERS:
                    getTeacherResponse(req, resp);
                    break;
                case TEACHERS_PAGE:
                    getTeacherPage(req, resp);
                    break;
                default:
                    getStudentPage(req, resp);

            }
        } else {
            if (req.getParameterMap().containsKey(ID)) {
                getOneStudentPage(req, resp);
            } else if (req.getParameterMap().containsKey(PAGE)) {
                if (req.getParameter(PAGE).equals(ADD_STUDENT)) {
                    getAddStudentPage(req, resp);
                }
            } else {
                getStudentPage(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       saveStudent(req,resp);
    }

    private void saveStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestData = new BufferedReader(new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));
        getResponse(resp, service.save(User.toJson(requestData)));


    }

    private void getAddStudentPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/users/add_student.jsp");
        rd.include(req, resp);
    }

    private void getStudentResponse(HttpServletRequest req, HttpServletResponse resp, Long id) throws ServletException, IOException {
        User user = service.findById(id);
        getResponse(resp, user);
    }

    private void getOneStudentPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/users/student.jsp");
        rd.include(req, resp);
    }

    private void getTeacherPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/users/teachers.jsp");
        rd.include(req, resp);
    }

    private void getTeacherResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> users = service.getTeachers();
        getResponse(resp, users);
    }

    private void getStudentsResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> users = service.findAll();
        getResponse(resp, users);
    }

    private <T> void getResponse(HttpServletResponse resp, T t) throws IOException {
        ResponseData<T> responseData = new ResponseData<>(true, t, "Success",
                200);
        resp.setStatus(200);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(ResponseData.toJson(responseData));
        printWriter.flush();
        printWriter.close();
    }

    private void getStudentPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/users/students.jsp");
        rd.include(req, resp);
    }
}
