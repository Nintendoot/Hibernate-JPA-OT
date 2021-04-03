package by.nintendo.controller;

import by.nintendo.entity.MyUser;
import by.nintendo.service.RegistrationService;
import by.nintendo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class AuthorithationController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/reg")
    public ModelAndView registView(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView regist(MyUser user, ModelAndView modelAndView) {
            userService.save(user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(path = "/auth")
    public ModelAndView authorView(String login,ModelAndView modelAndView) {
        modelAndView.addObject("userSession", new MyUser());
        modelAndView.setViewName("authorithation");
        return modelAndView;
    }
}
