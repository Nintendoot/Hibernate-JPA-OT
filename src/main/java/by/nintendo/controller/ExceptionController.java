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
    public String userAlreadyExists(UserAlreadyExistsException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
      return "error";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        if (e.getLocalizedMessage().equals("User not found")) {
            return "findUser";
        } else if (e.getLocalizedMessage().equals("Login Exist.")) {
            return "registration";
        }
        return "deleateUser";
    }

    @ExceptionHandler(NotAllDataEnteredException.class)
    public String userNoAllData(NotAllDataEnteredException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        if (e.getMessage().equals("Not data entered")) {
            return "findUser";
        } else {
            return "addUser";
        }
    }
}
