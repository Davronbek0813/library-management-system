package uz.pdp.librarymanagementsystem.authors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.user.User;
import uz.pdp.librarymanagementsystem.user.UserDao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update-author")
public class UpdateAuthor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String sid = req.getParameter("id");

        int id = Integer.parseInt(sid);

        User user = UserDao.getEmployeById(id);
Author author=AuthorDao.getEmployeById(id);

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +

                "</head>\n" +
                "<body>\n" +
                "    <form action=\"update-author\" method=\"post\"  width='95%'  >\n" +
                "        <h3>UPDATE USER</h3>\n" +
                "\n" +
        "        <input type=\"hidden\" name=\"id\" value='" + author.getId() + "'/>\n" +
                "        <tr><td>FULLNAME</td></tr>\n" +
                "        <input type=\"text\" name=\"fullname\" value='" + author.getFullName() + "'/>\n" +
                "  <button type=\"submit\">UPDATE</button>\n" +
                "\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sid=request.getParameter("id");
        int id= Integer.parseInt(sid);

        String fullname = request.getParameter("fullname");


        Author author=new Author();
        author.setId( id);
        author.setFullName(fullname);


        int status = AuthorDao.update(author);
        if (status > 0) {
            response.sendRedirect("/authors");

        } else {
            out.println("<h1>Sorry! unable to update record</h1>");
        }

        out.close();

    }
}
