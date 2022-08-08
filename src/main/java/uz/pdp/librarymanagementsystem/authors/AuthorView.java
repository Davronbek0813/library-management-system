package uz.pdp.librarymanagementsystem.authors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/authors")
public class AuthorView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter=resp.getWriter();
        List<Author> authorList= AuthorDao.getAllAuthors();
        req.setAttribute("list",authorList);
        req.getRequestDispatcher("view-author.jsp").forward(req,resp);
        resp.setContentType("text/html");

        printWriter.close();
    }
}
