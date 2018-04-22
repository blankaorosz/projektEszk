/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.ftdl.controller;

import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.model.Todo;
import hu.elte.ftdl.repository.UserRepository;
import hu.elte.ftdl.security.FtdlUserPrincipal;
import hu.elte.ftdl.service.TodoService;
import hu.elte.ftdl.service.exceptions.UserNotValidException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Blanka Orosz
 */
@Controller
@RequestMapping("/todo")
public class TODOController {
    
    @Autowired
    private TodoService todoService;
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/list")
    public String todo(Model model) {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (! (o instanceof FtdlUserPrincipal)) {
            throw new UserNotValidException("Unexpected behaviour! Not the correct principal is set");
        }
        
        FtdlUserPrincipal principal = (FtdlUserPrincipal) o;
        
        Family f = userRepository.findByUsername(principal.getUsername()).get();
        Collection<Todo> todoList = todoService.getTodoListByFamily(f);
        
        model.addAttribute("todoList", todoList);
        
        return "todo";
    }
}
