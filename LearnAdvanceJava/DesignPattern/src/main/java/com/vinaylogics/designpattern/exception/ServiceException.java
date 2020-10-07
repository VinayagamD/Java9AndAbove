package com.vinaylogics.designpattern.exception;

public class ServiceException  extends Exception{

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, DaoException cause) {
        super(message, cause);
    }
}
