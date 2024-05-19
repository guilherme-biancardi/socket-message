/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import DTO.CreateUserDTO;
import aps.User;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author guilh
 */
public class UserRepository implements UserRepositoryInterface {

    @Override
    public void create(CreateUserDTO user) throws SQLException {
        Statement query = new Database().getQuery();

        String sql = String.format("INSERT INTO users (name, email, password) VALUES ('%s','%s','%s')", user.name(), user.email(), user.password());
        query.executeUpdate(sql);
    }

    @Override
    public User auth(String email, String password) throws SQLException {
        Statement query = new Database().getQuery();

        String sql = String.format("SELECT * FROM users WHERE email = '%s' AND password = '%s'", email, password);
        ResultSet rs = query.executeQuery(sql);

        String userName = rs.getString("name");
        String userEmail = rs.getString("email");
        int userId = rs.getInt("id");
            
        User user = new User(userName, userEmail, userId);
            
        return user;
    }

    @Override
    public User getById(int id) throws SQLException {
        Statement query = new Database().getQuery();

        String sql = String.format("SELECT * FROM users WHERE id = '%d'", id);
        ResultSet rs = query.executeQuery(sql);

        String userName = rs.getString("name");
        String userEmail = rs.getString("email");
        int userId = rs.getInt("id");
            
        User user = new User(userName, userEmail, userId);
            
        return user;
    }

    
}
