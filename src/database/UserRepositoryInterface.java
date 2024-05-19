/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package database;

import DTO.CreateUserDTO;
import java.sql.SQLException;
import aps.User;

/**
 *
 * @author guilh
 */
public interface UserRepositoryInterface {
    public void create(CreateUserDTO user) throws SQLException;
    
    public User auth(String email, String password) throws SQLException;
    
    public User getById(int id) throws SQLException;
}
