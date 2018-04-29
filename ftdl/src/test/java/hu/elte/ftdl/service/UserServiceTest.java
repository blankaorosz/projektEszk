/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.ftdl.service;

import hu.elte.ftdl.model.Family;
import hu.elte.ftdl.repository.UserRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Horváth Csilla
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    
    private UserService userservice;
    @Autowired
    public void setUserService(UserService userservice){
        this.userservice = userservice;
    }
    
    public UserServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of register method, of class UserService.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        Family user = new Family(5,"Csilla","Csilla","bla");
        UserService instance = userservice;
        Family expResult = user;
        Family result = instance.register(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserRepository method, of class UserService.
     */
    @Test
    public void testGetUserRepository() {
        System.out.println("getUserRepository");
        UserService instance = new UserService();
        UserRepository expResult = null;
        UserRepository result = instance.getUserRepository();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEncoder method, of class UserService.
     */
    @Test
    public void testGetEncoder() {
        System.out.println("getEncoder");
        UserService instance = new UserService();
        PasswordEncoder expResult = null;
        PasswordEncoder result = instance.getEncoder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class UserService.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UserService instance = new UserService();
        Family expResult = null;
        Family result = instance.getUser();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserRepository method, of class UserService.
     */
    @Test
    public void testSetUserRepository() {
        System.out.println("setUserRepository");
        UserRepository userRepository = null;
        UserService instance = new UserService();
        instance.setUserRepository(userRepository);
    }

    /**
     * Test of setEncoder method, of class UserService.
     */
    @Test
    public void testSetEncoder() {
        System.out.println("setEncoder");
        PasswordEncoder encoder = null;
        UserService instance = new UserService();
        instance.setEncoder(encoder);
    }

    /**
     * Test of setUser method, of class UserService.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        Family user = null;
        UserService instance = new UserService();
        instance.setUser(user);
    }

    /**
     * Test of equals method, of class UserService.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of canEqual method, of class UserService.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class UserService.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserService instance = new UserService();
        int expResult = 0;
        int result = instance.hashCode();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of toString method, of class UserService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserService instance = new UserService();
        String expResult = "";
        String result = instance.toString();
        assertNotEquals(expResult, result);
    }
    
}
