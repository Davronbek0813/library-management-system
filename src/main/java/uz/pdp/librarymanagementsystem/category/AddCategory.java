package uz.pdp.librarymanagementsystem.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-category")
public class AddCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <!-- Design by foolishdeveloper.com -->\n" +
                "    <title>Glassmorphism login Form Tutorial in html css</title>\n" +
                " \n" +
                "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n" +
                "    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap\" rel=\"stylesheet\">\n" +
                "    <!--Stylesheet-->\n" +
                "    <style media=\"screen\">\n" +
                "      *,\n" +
                "*:before,\n" +
                "*:after{\n" +
                "    padding: 0;\n" +
                "    margin: 0;\n" +

                "}\n" +
                "body{\n" +
                "    background-color: #080710;\n" +
                "}\n" +
                ".background{\n" +
                "    width: 430px;\n" +
                "    height: 520px;\n" +
                "    position: absolute;\n" +
                "    transform: translate(-50%,-50%);\n" +
                "    left: 50%;\n" +
                "    top: 50%;\n" +
                "}\n" +
                ".background .shape{\n" +
                "    height: 200px;\n" +
                "    width: 200px;\n" +
                "    position: absolute;\n" +
                "    border-radius: 50%;\n" +
                "}\n" +
                ".shape:first-child{\n" +
                "    background: linear-gradient(\n" +
                "        #1845ad,\n" +
                "        #23a2f6\n" +
                "    );\n" +
                "    left: -80px;\n" +
                "    top: -80px;\n" +
                "}\n" +
                ".shape:last-child{\n" +
                "    background: linear-gradient(\n" +
                "        to right,\n" +
                "        #ff512f,\n" +
                "        #f09819\n" +
                "    );\n" +
                "    right: -30px;\n" +
                "    bottom: -80px;\n" +
                "}\n" +
                "form{\n" +
                "    height: 520px;\n" +
                "    width: 400px;\n" +
                "    background-color: rgba(255,255,255,0.13);\n" +
                "    position: absolute;\n" +
                "    transform: translate(-50%,-50%);\n" +
                "    top: 50%;\n" +
                "    left: 50%;\n" +
                "    border-radius: 10px;\n" +
                "    backdrop-filter: blur(10px);\n" +
                "    border: 2px solid rgba(255,255,255,0.1);\n" +
                "    box-shadow: 0 0 40px rgba(8,7,16,0.6);\n" +
                "    padding: 50px 35px;\n" +
                "}\n" +
                "form *{\n" +
                "    font-family: 'Poppins',sans-serif;\n" +
                "    color: #ffffff;\n" +
                "    letter-spacing: 0.5px;\n" +
                "    outline: none;\n" +
                "    border: none;\n" +
                "}\n" +
                "form h3{\n" +
                "    font-size: 32px;\n" +
                "    font-weight: 500;\n" +
                "    line-height: 42px;\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                "label{\n" +
                "    display: block;\n" +
                "    margin-top: 30px;\n" +
                "    font-size: 16px;\n" +
                "    font-weight: 500;\n" +
                "}\n" +
                "input{\n" +
                "    display: block;\n" +
                "    height: 50px;\n" +
                "    width: 100%;\n" +
                "    background-color: rgba(255,255,255,0.07);\n" +
                "    border-radius: 3px;\n" +
                "    padding: 0 10px;\n" +
                "    margin-top: 8px;\n" +
                "    font-size: 14px;\n" +
                "    font-weight: 300;\n" +
                "}\n" +
                "::placeholder{\n" +
                "    color: #e5e5e5;\n" +
                "}\n" +
                "button{\n" +
                "    margin-top: 50px;\n" +
                "    width: 100%;\n" +
                "    background-color: #ffffff;\n" +
                "    color: #080710;\n" +
                "    padding: 15px 0;\n" +
                "    font-size: 18px;\n" +
                "    font-weight: 600;\n" +
                "    border-radius: 5px;\n" +
                "    cursor: pointer;\n" +
                "}\n" +
                ".social{\n" +
                "  margin-top: 30px;\n" +
                "  display: flex;\n" +
                "}\n" +
                ".social div{\n" +
                "  background: red;\n" +
                "  width: 150px;\n" +
                "  border-radius: 3px;\n" +
                "  padding: 5px 10px 10px 5px;\n" +
                "  background-color: rgba(255,255,255,0.27);\n" +
                "  color: #eaf0fb;\n" +
                "  text-align: center;\n" +
                "}\n" +
                ".social div:hover{\n" +
                "  background-color: rgba(255,255,255,0.47);\n" +
                "}\n" +
                ".social .fb{\n" +
                "  margin-left: 25px;\n" +
                "}\n" +
                ".social i{\n" +
                "  margin-right: 4px;\n" +
                "}\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"background\">\n" +
                "        <div class=\"shape\"></div>\n" +
                "        <div class=\"shape\"></div>\n" +
                "    </div>\n" +
                "   <form action=\"add-author\" method=\"post\">" +
                "        <h3>AUTHOR ADD</h3>\n" +
                "\n" +
                "        <label>NAME</label>\n" +
                "        <input type=\"text\" placeholder=\"Enter name\" name=\"name\">\n" +
                "       <button type=\"submit\">ADD CATEGORY</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");

        Category category=new Category();
        category.setName(name);

       CategoryDao.save(category);
        System.out.println(category);
        System.out.println("add");
        resp.sendRedirect("/category");
        out.close();

    }
}
