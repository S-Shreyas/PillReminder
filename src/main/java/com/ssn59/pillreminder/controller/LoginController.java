package com.ssn59.pillreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssn59.pillreminder.services.UserServicesImpl;
import com.ssn59.pillreminder.userlogindto.UserLoginDTO;

@Controller
public class LoginController {

	@Autowired
	UserServicesImpl userServicesImpl;

	@ModelAttribute("user")
	public UserLoginDTO userLoginDTO() {
		return new UserLoginDTO();
	}

	@GetMapping()
	public String getLoginPage() {
		return "index";
	}

	// @RequestMapping(value = "/register", method = {RequestMethod.GET,
	// RequestMethod.POST})
	@GetMapping("/register")
	public String showRegistrationForm() {
		return "register";
	}

	@PostMapping("/register")
	public String userRegistration(@ModelAttribute("user") UserLoginDTO userLoginDTO) {

		if(userServicesImpl.userExist(userLoginDTO.getEmail())) {
			
			return "redirect:/register?erroremail";
		}else if(userServicesImpl.phoneExists(userLoginDTO.getPhone())){
			
			return "redirect:/register?errorphone";
			
		}
		
		
		userServicesImpl.save(userLoginDTO);
		
		
		return "redirect:/register?success";
		
		

	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String logger(@RequestParam String email, @RequestParam String pass) {

		Boolean tracker = userServicesImpl.userValidation(email, pass);

		if (tracker) {
			return "homepage";
		}
		return "redirect:/login?error";

	}
	@GetMapping("/forgotpass")
	public String resetPassword() {
		return "forgotpass";
	}

//	@PutMapping("/resetpass")
//	public String changeUserPassword(Map<String, String> body) {
//
//		System.out.println("changeUserPassword");
//		return userServicesImpl.changePass(body);
//
//	}

}
