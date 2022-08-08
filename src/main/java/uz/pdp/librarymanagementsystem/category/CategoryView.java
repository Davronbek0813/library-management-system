package uz.pdp.librarymanagementsystem.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/category")
public class CategoryView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter=resp.getWriter();
        List<Category> categoryList= CategoryDao.getAllCategories();
        req.setAttribute("list",categoryList);
        req.getRequestDispatcher("view-category.jsp").forward(req,resp);
        resp.setContentType("text/html");

        printWriter.close();
    }
}
