package am.tech42.onlineshop.service;

import am.tech42.onlineshop.db.DatabaseHelper;
import am.tech42.onlineshop.model.User;
import org.postgresql.util.PSQLException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {


    public static User registerUser (String phone,String pass,String name) throws SQLException{
        String sql = "Insert into users (name,phone_number,password) values (?,?,?)";
        var ps = DatabaseHelper.getConnection().prepareStatement(sql);
        ps.setString(1,name);
        ps.setString(2,phone);
        ps.setString(3,pass);
        ps.execute();
        return loginUser(phone,pass);
       }

    public static User loginUser(String phone, String pass) {
        String sql = "select id ,name from users where phone_number=? and password=?";
        try {
            var ps = DatabaseHelper.getConnection().prepareStatement(sql);
            ps.setString(1,phone);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                return new User(id, phone, pass, name);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
