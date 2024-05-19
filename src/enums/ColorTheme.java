/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author guilh
 */
public enum ColorTheme {
    LIGHT("light"),
    DARK("dark");

    public String theme;

    private ColorTheme(String theme) {
        this.theme = theme;
    }
}