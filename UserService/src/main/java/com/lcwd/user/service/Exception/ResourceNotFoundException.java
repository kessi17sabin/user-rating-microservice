package com.lcwd.user.service.Exception;

public class ResourceNotFoundException extends RuntimeException{

    // extra param that you want can be added
    public ResourceNotFoundException() {
        super("Resource not found on server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
