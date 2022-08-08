package uz.pdp.librarymanagementsystem.issuedReturnedBooks;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;






public class IssuedDao {


    public static boolean add(IssuedReturnedBooks issuedReturnedBooks) {

        Connection connection = DbConnection.getConnection();
        int status = 0;

        try {
            PreparedStatement ps  = connection.prepareStatement("insert into issued_returned (user_id, book_id, issued) " +
                    "values (?,?,?) ");

            ps.setLong(1,issuedReturnedBooks.getUserId());
            ps.setLong(2,issuedReturnedBooks.getBookId());
            ps.setBoolean(3, issuedReturnedBooks.isIssued());


             status = ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status > 0;
    }
}
