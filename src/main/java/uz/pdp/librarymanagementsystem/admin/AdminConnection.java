package uz.pdp.librarymanagementsystem.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin-boglanish")
public class AdminConnection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
       out.println("<br><br><br><br><center><a href=\"https://www.instagram.com/davronbek_13_08/\">Instagram</a></center> ");
        out.println("<br><center>Telegram: davronbek0813</center> ");
        out.println("<br><center>Phone:+998907746242</center> ");



        out.close();

    }
}
