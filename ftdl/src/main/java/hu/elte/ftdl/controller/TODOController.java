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
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/list")
    public String create(@ModelAttribute Todo todo) {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (! (o instanceof FtdlUserPrincipal)) {
            throw new UserNotValidException("Unexpected behaviour! Not the correct principal is set");
        }
        
        FtdlUserPrincipal principal = (FtdlUserPrincipal) o;    
        Family f = userRepository.findByUsername(principal.getUsername()).get();

        if(f == null)
            throw new UserNotValidException("Unexpected behaviour! Not the correct principal is set");

        todo.setFamily(f);

        Todo saved = todoService.create(todo, f);

        return "redirect:/todo/list";
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable int id) {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (! (o instanceof FtdlUserPrincipal)) {
            throw new UserNotValidException("Unexpected behaviour! Not the correct principal is set");
        }
        
        FtdlUserPrincipal principal = (FtdlUserPrincipal) o;    
        Family f = userRepository.findByUsername(principal.getUsername()).get();

        Todo t = todoService.find(id);

        if(t.getFamily() != f)
            return ResponseEntity.badRequest().build();

        todoService.delete(t);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Todo> update(@PathVariable int id, @RequestBody Todo todo) {
        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (! (o instanceof FtdlUserPrincipal)) {
            throw new UserNotValidException("Unexpected behaviour! Not the correct principal is set");
        }
        
        FtdlUserPrincipal principal = (FtdlUserPrincipal) o;    
        Family f = userRepository.findByUsername(principal.getUsername()).get();

        Todo t = todoService.find(id);
        if(t.getFamily() != f)
            return ResponseEntity.badRequest().build();

        Todo updated = todoService.update(id, todo);

        return ResponseEntity.ok(updated);

    }
}
