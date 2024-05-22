package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.DTO.UserLoginDTO;
import com.example.springboot.service.DefaultUserService;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private DefaultUserService userService;

	/*
	 * public LoginController(DefaultUserService userService) { super();
	 * this.userService = userService; }
	 */
    
    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
    
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public String loginUser(@ModelAttribute("user")
	UserLoginDTO userLoginDTO) {
		System.out.println("UserDTO"+userLoginDTO);
		 userService.loadUserByUsername(userLoginDTO.getUsername());
		 return "dashboard";
		
	}
}


