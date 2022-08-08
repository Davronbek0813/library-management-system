package uz.pdp.librarymanagementsystem.sign;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.user.User;
import uz.pdp.librarymanagementsystem.user.UserDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out =resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        List<User> list= UserDao.view();

        for (User user : list) {
            System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getRole());
        }

        int a=0;
        for (User user : list) {
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                   if(user.getRole().equals("SUPER_ADMIN")){

                       a=1;
                   }else if(user.getRole().equals("ADMIN")){

                       a=2;
                   }else {

                       a=3;
                }

            }
        }

        switch (a){
            case 0 :
                resp.sendRedirect("add-user1");
                break;
            case 1:
                resp.sendRedirect("books");
                break;

            case 2:
                resp.sendRedirect("books");
                break;

            case 3:
                resp.sendRedirect("booksuser");
                break;
        }


            // out.println("Siz avval ro'yxatdan o'tishingiz kerak!");
            //req.getRequestDispatcher("/add-user").include(req,resp);



            out.close();
    }
}
