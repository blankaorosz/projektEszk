package hu.elte.ftdl.controller;

/**
 *
 * @author Horváth Csilla
 */
import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        if (userService.isLoggedIn()) {
            return redirectToTODOList();
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new Family());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Family user, HttpServletRequest request) {
        userService.register(user);

        return "redirect:/user/login";
    }

    private String redirectToTODOList() {
        return "redirect:/todo/list";
    }
}
