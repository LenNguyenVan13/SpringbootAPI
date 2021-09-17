package com.example.springbootapi.error;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(){
        super();
    }

    public EmployeeNotFoundException(String message){
        super(message);
    }

    public EmployeeNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public EmployeeNotFoundException(Throwable cause){
        super(cause);
    }

    protected EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace){
        super(message,cause,enableSuppression,writeableStackTrace);
    }
}
