/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DTO.CreateUserDTO;
import enums.PageEnum;
import aps.Pages;
import aps.User;
import components.Alert;
import database.UserRepository;
import forms.ChatForm;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class UserController {

    private final UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }

    public void authenticate(String email, String password) throws SQLException, IOException {

        User user = userRepository.auth(email, password);

        Pages.setPage(PageEnum.CHAT, new ChatForm(user));
    }

    public void register(String name, String email, String password) {

        try {
            CreateUserDTO dto = new CreateUserDTO(name, email, password);
            userRepository.create(dto);
        } catch (SQLException ex) {
            Alert.error("Usuário não adicionado", "Erro ao adicionar um novo usuário");
        }

    }
}
