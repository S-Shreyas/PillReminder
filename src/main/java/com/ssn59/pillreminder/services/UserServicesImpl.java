package com.ssn59.pillreminder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public String changePass(UserLoginDTO userLoginDTO) {

		return "";

	}

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

	public User viewCurrentPerson(String email) {

		return userLoginDAO.findByEmail(email);
	}

	public Boolean verifyPass(String pass, String email) {
		
		System.out.println("Inside verifyPass");

		User dto = userLoginDAO.findByEmail(email);
		if (pass.equals(dto.getPass())) {
			return true;

		}
		return false;
	}
}
