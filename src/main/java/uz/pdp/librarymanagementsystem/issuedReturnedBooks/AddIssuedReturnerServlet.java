package uz.pdp.librarymanagementsystem.issuedReturnedBooks;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.BookDao;
import uz.pdp.librarymanagementsystem.user.UserDao;

import java.io.IOException;


@WebServlet("/addissue")
@MultipartConfig(maxFileSize = 10_000_000)
public class AddIssuedReturnerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        Boolean added = Boolean.valueOf(req.getParameter("added"));
        if (added) {
            req.setAttribute("message", "Successfully added!!!");
            req.getRequestDispatcher("/books").forward(req,resp);
            return;
        }


        req.setAttribute("userList", UserDao.view());
        req.setAttribute("bookList", BookDao.getAllBookList());
        req.getRequestDispatcher("issue-return-book.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String bookId = req.getParameter("bookId");
        Boolean boolRadio = Boolean.valueOf(req.getParameter("issued"));

        IssuedReturnedBooks issuedReturnedBooks  = IssuedReturnedBooks.builder()
                .bookId(Integer.valueOf(bookId))
                .userId(Integer.valueOf(userId))
                .issued(boolRadio)
                .build();
        Boolean add = IssuedDao.add(issuedReturnedBooks);


            if (add) {
               resp.sendRedirect("/addissue?added=true");
            }

        }
}
