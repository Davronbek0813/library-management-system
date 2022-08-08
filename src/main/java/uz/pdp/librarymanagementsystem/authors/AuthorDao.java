package uz.pdp.librarymanagementsystem.authors;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

    public static int save(Author a){
        int status=0;
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("insert into authors(fullname) values(?)");
            ps.setString(1,a.getFullName());
            status=ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
    public static  int delete(int id){
        int status=0;
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("delete from authors where id=?");
            ps.setInt(1,id);
            status= ps.executeUpdate();
        } catch (SQLException e) {


        }
        return status;
    }

    public static int update(Author a){
        int status=0;
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("update authors set fullname=? where id="+a.getId());
            ps.setString(1,a.getFullName()
            );
            status =ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }







    public static List<Author> getAllAuthors() {


        try (Connection connection = DbConnection.getConnection();) {
            List<Author> authorList = new ArrayList<>();

            String sql = "select * from authors";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String fullName = resultSet.getString("fullName");

                Author author = Author.builder()
                        .id(id)
                        .fullName(fullName)
                        .build();

                authorList.add(author);
            }

            return authorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Author getEmployeById(int id){
       Author a=new Author();
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("select * from authors where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                a.setId(rs.getInt(1));
                a.setFullName(rs.getString(2));
            }connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
}
