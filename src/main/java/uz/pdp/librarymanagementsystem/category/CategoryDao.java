package uz.pdp.librarymanagementsystem.category;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public static int save(Category c){
        int status=0;
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("insert into categories(name) values(?)");
            ps.setString(1,c.getName());
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
            PreparedStatement ps=connection.prepareStatement("delete from categories where id=?");
            ps.setInt(1,id);
            status= ps.executeUpdate();
        } catch (SQLException e) {


        }
        return status;
    }

    public static int update(Category c){
        int status=0;
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("update categories set name=? where id="+c.getId());
            ps.setString(1,c.getName());
            status =ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }
    public static Category getEmployeById(int id){
        Category c=new Category();
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("select * from categories where id =?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));

            }connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public static List<Category> getAllCategories() {


        try (Connection connection = DbConnection.getConnection();) {
            List<Category> categoryList = new ArrayList<>();

            String sql = "select * from categories";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Category category = Category.builder()
                        .id(id)
                        .name(name)
                        .build();

                categoryList.add(category);
            }

            return categoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
