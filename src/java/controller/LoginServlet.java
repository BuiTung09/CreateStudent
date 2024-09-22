package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.swing.text.html.HTML;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
        String param_user = req.getParameter("username");
        String param_pass = req.getParameter("password");
        
        String username = req.getServletContext().getInitParameter("username");
        String password = req.getServletContext().getInitParameter("password");
        
        if(param_user.equals(username) && param_pass.equals(password)){
            req.getSession().setAttribute("user", param_user);
            resp.sendRedirect("index.html");
        }
        else{
            resp.getWriter().println("login fail!");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher("login.html").forward(req, resp);     
    }
    
    
}
