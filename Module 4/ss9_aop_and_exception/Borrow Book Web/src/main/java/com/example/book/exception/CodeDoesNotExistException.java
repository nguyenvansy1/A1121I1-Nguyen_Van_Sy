package com.example.book.exception;

public class CodeDoesNotExistException extends Exception{
    @Override
    public String getMessage(){
        return "Book is not available";
    }
}
