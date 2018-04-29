/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.ftdl.service;

import com.fasterxml.classmate.AnnotationConfiguration;
import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.model.Todo;
import java.util.ArrayList;
import java.util.Collection;
import javax.transaction.Transactional;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Horváth Csilla
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoServiceTest {
    
     private TodoService todoservice;
    @Autowired
    public void setUserService(TodoService todoservice){
        this.todoservice = todoservice;
    }
    public TodoServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of create method, of class TodoService.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Family family = new Family(0, "test", "test", "Teszt");
        Todo todo = new Todo(324324, family, "Teszteles", "Pistike",false, 1);
        TodoService instance = todoservice;
        Todo expResult = todo;
        Todo result = instance.create(todo, family);
        assertEquals(expResult.getTask(), result.getTask());
    }

    /**
     * Test of update method, of class TodoService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int id = 200;
        Family family = new Family(0, "test", "test", "Teszt");
        Todo todo = new Todo(200, family, "Teszt feladat", "Pisti", false, 1);
        TodoService instance = todoservice;
        Todo expResult = todo;
        Todo result = instance.update(200, todo);
        assertEquals(expResult.getStatus(), result.getStatus());
    }

    /**
     * Test of find method, of class TodoService.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 200;
        TodoService instance = todoservice;
        Family family = new Family(0, "test", "test", "Teszt");
        Todo expResult = new Todo(200, family, "Teszt feladat", "Pisti", true, 1);
        Todo result = instance.find(id);   
        assertEquals(expResult.getId(), result.getId());    
    }
    
}
