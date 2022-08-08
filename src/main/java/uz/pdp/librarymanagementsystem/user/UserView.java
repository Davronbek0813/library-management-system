package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/users")
public class UserView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter=resp.getWriter();
        List<User> userList= UserDao.view();
        System.out.println(userList);
        req.setAttribute("list",userList);
        req.getRequestDispatcher("view-user.jsp").forward(req,resp);
        resp.setContentType("text/html");
 
        printWriter.close();
    }
}
