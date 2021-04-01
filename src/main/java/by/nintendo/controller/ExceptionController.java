package by.nintendo.controller;

import by.nintendo.exception.NotAllDataEnteredException;
import by.nintendo.exception.UserAlreadyExistsException;
import by.nintendo.exception.UserNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public String userno(UserAlreadyExistsException e, Model model){
        model.addAttribute("errorMessage",e.getMessage());
        return "errorPage";
    }
    @ExceptionHandler(UserNotFoundException.class)
    public String userno(UserNotFoundException e, Model model){
        model.addAttribute("errorMessage",e.getMessage());
        return "errorPage";
    }
    @ExceptionHandler(NotAllDataEnteredException.class)
    public String userno(NotAllDataEnteredException e, Model model){
        model.addAttribute("errorMessage",e.getMessage());
        return "errorPage";
    }
}
