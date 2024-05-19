/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author guilh
 */
public enum PageEnum {
    LOGIN("login"),
    REGISTER("register"),
    CHAT("chat");

    public String page;

    private PageEnum(String page) {
        this.page = page;
    }
}