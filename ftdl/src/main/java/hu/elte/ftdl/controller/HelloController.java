package hu.elte.ftdl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vimtaai on 2017. 09. 18..
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }
}
