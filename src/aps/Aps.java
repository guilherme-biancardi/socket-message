/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aps;

import enums.PageEnum;
import enums.ColorTheme;
import database.Database;
import forms.LoginForm;

/**
 *
 * @author guilh
 */
public class Aps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Colors.setTheme(ColorTheme.LIGHT);
        Database.initTables();
        
        Pages.setPage(PageEnum.LOGIN, new LoginForm());
        Pages.redirect(PageEnum.LOGIN, null); 
    }

}
