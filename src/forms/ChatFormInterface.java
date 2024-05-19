/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package forms;

import components.MessageComponentInterface;

/**
 *
 * @author guilh
 */
public interface ChatFormInterface {
    public void sendMessage();
    public void rendererMessage(MessageComponentInterface component);
    public void closeOnError(String message);
    public void logout();
}
