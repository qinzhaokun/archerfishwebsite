package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/create/{name}/{password}") 
    public User  createUser(@PathVariable("name") String name,@PathVariable("password") String password) {
		if(userService.getUserByName(name) != null){
			return null;
		}
		else{
			User user = new User();
			user.setName(name);user.setPassword(password);
			return userService.createUser(user);
		}

    } 
	
	@RequestMapping("/user/{name}/{password}") 
	public Map isUserValidation(@PathVariable("name") String name,@PathVariable("password") String password){
		User user = userService.getUserByName(name);
		Map<String,Object> map = new HashMap<String,Object>();
		if(user == null){
			map.put("result", "user not exists");
		}
		
		else if(!user.getPassword().equals(password)){
			map.put("result", "password is incorrect");
		}
		else{
			map.put("result", "success");
			map.put("servers", user.getServers());
		}
		return map;
	}
	 
  
}
