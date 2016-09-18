package controller;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import model.User;  
   
@RestController
public class HelloWorldController {  
    String message = "Welcome to Spring MVC!";  
   
    @RequestMapping("/hello")  
    public ModelAndView showMessage(  
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {  
        System.out.println("in controller");  
   
        ModelAndView mv = new ModelAndView("helloworld");  
        mv.addObject("message", message);  
        mv.addObject("name", name);  
        return mv;  
    }  
    
    @RequestMapping("/hello1")  
    public User showMessage1(  
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {  
        System.out.println("in controller2");  
   
        User user = new User(); user.setName(name);
        return user;  
    }
    
}  