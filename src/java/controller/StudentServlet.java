package controller;

import Entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user")==null){
            resp.sendRedirect("login.html");
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Date dob = Date.valueOf(req.getParameter("dob"));
        boolean gender = req.getParameter("gender").equals("male");
        
        Student student = new Student(id, name, dob, gender);
        resp.getWriter().println("ID : " + student.getId());
        resp.getWriter().println("Name : " + student.getName());
        resp.getWriter().println("Dob : " + student.getDob());
        resp.getWriter().println("Gender : " + (student.isGender()?"male":"female"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") == null){
            resp.sendRedirect("login.html");
        }
        else{
            req.getRequestDispatcher("../index.html").forward(req, resp);
        }
    }
    
    
    
}
