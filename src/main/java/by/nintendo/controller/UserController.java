package by.nintendo.controller;

import by.nintendo.entity.MyUser;
import by.nintendo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView viewAddUser(ModelAndView modelAndView) {
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(MyUser user, ModelAndView modelAndView) {
        userService.save(user);
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @GetMapping(path = "/allUsers")
    public ModelAndView allUsers(ModelAndView modelAndView) {
        modelAndView.addObject("all", userService.findAll());
        modelAndView.setViewName("allUsers");
        return modelAndView;
    }

    @GetMapping(path = "/deleate")
    public ModelAndView viewDelete(ModelAndView modelAndView) {
        modelAndView.setViewName("deleateUser");
        return modelAndView;
    }

    @PostMapping(path = "/deleate")
    public ModelAndView deleate(MyUser user, ModelAndView modelAndView) {
        userService.deleteUser(user);
        modelAndView.addObject("deleate", "User Deleate");
        modelAndView.setViewName("deleateUser");
        return modelAndView;
    }

    @GetMapping(path = "/find")
    public ModelAndView viewFind(ModelAndView modelAndView) {
        modelAndView.setViewName("findUser");
        return modelAndView;
    }

    @PostMapping(path = "/findByLogin")
    public ModelAndView findUserByLogin(String login, ModelAndView modelAndView) {
        MyUser byLogin = userService.findByLogin(login);
        modelAndView.setViewName("findUser");
        modelAndView.addObject("user", byLogin);
        return modelAndView;
    }

    @PostMapping(path = "/findById")
    public ModelAndView findUserById(Long id, ModelAndView modelAndView) {
        MyUser byId = userService.findById(id);
        modelAndView.setViewName("findUser");
        modelAndView.addObject("user", byId);
        return modelAndView;
    }

}
