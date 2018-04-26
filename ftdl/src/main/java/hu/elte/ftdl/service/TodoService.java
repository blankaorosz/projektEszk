/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.ftdl.service;

import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.model.Todo;
import hu.elte.ftdl.repository.ToDoRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Blanka Orosz
 */
@Service
public class TodoService {
    
    @Autowired
    private ToDoRepository toDoRepository;
    
    public Collection<Todo> getTodoListByFamily(Family family) {
        return toDoRepository.findByFamily(family);
    }

    public Todo create(Todo todo, Family family) {
        todo.setStatus(false);
        todo.setFamily(family);
        return toDoRepository.save(todo);

    }

    public Todo update(int id, Todo todo) {
        Todo currentTodo = toDoRepository.findById(id).get();
        currentTodo.setStatus(todo.getStatus());
        currentTodo.setOwner(todo.getOwner());
        currentTodo.setTask(todo.getTask());
        return toDoRepository.save(currentTodo);

    }

    public void delete(Todo todo) {
        toDoRepository.delete(todo);
    }

    public Todo find(int id){
        return toDoRepository.findById(id).get();
    }
}
