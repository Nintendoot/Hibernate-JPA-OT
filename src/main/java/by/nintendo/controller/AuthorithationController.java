package by.nintendo.controller;

import by.nintendo.entity.MyUser;
import by.nintendo.service.RegistrationService;
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
    private RegistrationService registrationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(path = "/reg")
    public ModelAndView registView(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/reg")
    public ModelAndView regist(MyUser user, ModelAndView modelAndView) {
        if (!registrationService.findByLogin(user.getLogin())) {
            registrationService.saveUser(user);
        }
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
