package uz.pdp.librarymanagementsystem.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update-category")
public class UpdateCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String sid = req.getParameter("id");

        int id = Integer.parseInt(sid);

      Category category=CategoryDao.getEmployeById(id);

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +

                "</head>\n" +
                "<body>\n" +
                "    <form action=\"update-category\" method=\"post\"  width='95%'  >\n" +
                "        <h3>UPDATE CATEGORY</h3>\n" +
                "\n" +
        "        <input type=\"hidden\" name=\"id\" value='" + category.getId() + "'/>\n" +
                "        <tr><td>NAME</td></tr>\n" +
                "        <input type=\"text\" name=\"name\" value='" + category.getName() + "'/>\n" +
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

        String name = request.getParameter("name");


        Category category=new Category();
        category.setId( id);
        category.setName(name);


        int status = CategoryDao.update(category);
        if (status > 0) {
            response.sendRedirect("/category");

        } else {
            out.println("<h1>Sorry! unable to update record</h1>");
        }

        out.close();

    }
}
