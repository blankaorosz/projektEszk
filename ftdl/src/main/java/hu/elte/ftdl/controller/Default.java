package hu.elte.ftdl.controller;


import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class Default {


    @GetMapping
    public String def() {
        return "redirect:/todo/list";
    }

}
