package uz.pdp.librarymanagementsystem.user;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static  int save(User u){
        int status=0;
        Connection connection= DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("insert into users(username, password,role,fullname) values(?,?,?,?)");
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getRole());
            ps.setString(4,u.getFullname());
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
            PreparedStatement ps=connection.prepareStatement("delete from users where id=?");
            ps.setInt(1,id);
            status= ps.executeUpdate();
        } catch (SQLException e) {


        }
        return status;
    }

    public static int update(User u){
        int status=0;
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("update users set role=? where id="+u.getId());
//             ps.setString(1,u.getUsername());
//             ps.setString(2,u.getPassword());
//             ps.setString(3,u.getFullname());
             ps.setString(1,u.getRole());
             status =ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    public static List<User> view(){
        List<User> list=new ArrayList<>();
        Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("select * from users order by id");
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
             User u=new User();
             u.setId(rs.getInt(1));
             u.setUsername(rs.getString(2));
             u.setPassword(rs.getString(3));
             u.setRole(rs.getString(4));
             u.setFullname(rs.getString(5));
             list.add(u);
             connection.close();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static User getEmployeById(int id){
     User u=new User();
    Connection connection=DbConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("select * from users where id =?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
              u.setId(rs.getInt(1));
              u.setUsername(rs.getString(2));
              u.setPassword(rs.getString(3));
              u.setRole(rs.getString(4));
              u.setFullname(rs.getString(5));
            }connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

}
