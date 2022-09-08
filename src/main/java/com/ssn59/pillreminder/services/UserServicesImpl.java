package com.ssn59.pillreminder.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ssn59.pillreminder.User;
import com.ssn59.pillreminder.userlogindao.UserLoginDAO;
import com.ssn59.pillreminder.userlogindto.UserLoginDTO;

@Service
public class UserServicesImpl {

	@Autowired
	UserLoginDAO userLoginDAO;

	public String userLogin(UserLoginDTO userLoginDTO) {

		Boolean validationID = userValidation(userLoginDTO.getEmail(), userLoginDTO.getPass());

		if (validationID) {

			return "homepage";

		}
		return "redirect:/login?error";
	}

//	 {
//	 "fullname" : "Moley",
//	 "email" : "stupidthing@mail.com",
//	 "phone" : "4444444444",
//	 "country" : "Canada",
//	 "pass" : "asa",
//	 "DOB" : "1999-02-29"
//	 }

	public User save(UserLoginDTO userLoginDTO) {

		User user = new User(userLoginDTO.getFullname(), userLoginDTO.getEmail(), userLoginDTO.getPhone(),
				userLoginDTO.getCountry(), userLoginDTO.getDOB(), userLoginDTO.getPass());

		return userLoginDAO.save(user);
	}

//
//	public String changePass(@RequestBody Map<String, String> body) {
//
//		int validationID = userValidation(body.get("email"), body.get("pass"));
//
//		if (validationID == 1) {
//
//			String newPass = body.get("newpass");
//
//			Optional<User> val = userLoginDAO.findByEmail();
//			User dto = val.get();
//
//			dto.setEmail(body.get("email"));
//			dto.setPass(newPass);
//
//			userLoginDAO.save(dto);
//
//			return "Success";
//
//		}
//
//		return "Invalid password";
//
//	}
	public Boolean userExist(String email) {

		return userLoginDAO.existsByEmail(email);
	}
	public Boolean phoneExists(String phone) {
		
		return userLoginDAO.existsByPhone(phone);
		
	}

	public Boolean userValidation(String email, String pass) {

		if (userLoginDAO.existsByEmail(email)) {

			User dto = userLoginDAO.findByEmail(email);

			if (dto.getPass().equals(pass)) {

				return true;
			}

		}
		return false;
	}

	public ModelAndView viewOne(@PathVariable String email) {

		ModelAndView mav = new ModelAndView("ViewProfile");
		Optional<User> dto = userLoginDAO.findById(email);
		List<User> val = dto.map(Collections::singletonList).orElseGet(Collections::emptyList);
		mav.addObject("user", val);
		return mav;
	}

}
