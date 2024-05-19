/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author guilh
 */
public enum MessageType {
    MESSAGE("message"),
    NOTIFICATION("notification"),
    DISCONNECTION("disconnetion"),
    USER_IS_CONNECTED("user_connected");

    public String messageType;

    private MessageType(String type) {
        this.messageType = type;
    }
}