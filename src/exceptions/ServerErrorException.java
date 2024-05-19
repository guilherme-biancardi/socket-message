/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

import components.Alert;

/**
 *
 * @author guilh
 */
public class ServerErrorException extends Exception {

    public ServerErrorException(String message) {
        Alert.error("Erro de Servidor", message);
    }

}
