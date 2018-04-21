package hu.elte.ftdl.controller;

/**
 *
 * @author Horváth Csilla
 */

import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute(new Family());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Family user, Model model) {
        if (userService.isValid(user)) {
            return redirectToGreeting(user);
        }
        model.addAttribute("loginFailed", true);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Family());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Family user) {
        userService.register(user);
        return redirectToGreeting(user);
    }

    private String redirectToGreeting(@ModelAttribute Family user) {
        return "redirect:/user/greet?name=" + user.getUsername();
    }
}