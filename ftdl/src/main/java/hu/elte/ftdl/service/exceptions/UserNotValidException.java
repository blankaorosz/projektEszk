/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.ftdl.service.exceptions;

/**
 *
 * @author Horváth Csilla
 */
public class UserNotValidException extends RuntimeException {

    public UserNotValidException() {
    }

    public UserNotValidException(String message) {
        super(message);
    }
}
