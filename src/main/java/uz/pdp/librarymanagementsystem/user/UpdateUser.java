package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update-user")
public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String sid = req.getParameter("id");

        int id = Integer.parseInt(sid);

        User user = UserDao.getEmployeById(id);


        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +

                "</head>\n" +
                "<body>\n" +
                "    <form action=\"update-user\" method=\"post\"  width='95%'  >\n" +
                "        <h3>UPDATE USER</h3>\n" +
                "\n" +
        "        <input type=\"hidden\" name=\"id\" value='" + user.getId() + "'/>\n" +
                "        <tr><td>ROLE</td></tr>\n" +
                "        <input type=\"text\" name=\"role\" value='" + user.getRole() + "'/>\n" +
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

        String role = request.getParameter("role");


        User user = new User();
        user.setId(id);
        user.setRole(role);


        int status = UserDao.update(user);
        if (status > 0) {
            response.sendRedirect("/users");

        } else {
            out.println("<h1>Sorry! unable to update record</h1>");
        }

        out.close();

    }
}
