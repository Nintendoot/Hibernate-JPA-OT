package by.nintendo.controller;

import by.nintendo.Dao.UserDao;
import by.nintendo.entity.User;
import by.nintendo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView sas(ModelAndView modelAndView){

        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(User user, ModelAndView modelAndView){
        userService.save(user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(path = "/allUsers")
    public ModelAndView allUsers(ModelAndView modelAndView){
        modelAndView.addObject("all",userService.findAll());
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }

}
