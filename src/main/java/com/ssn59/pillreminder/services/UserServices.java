package com.ssn59.pillreminder.services;

import com.ssn59.pillreminder.User;
import com.ssn59.pillreminder.userlogindto.UserLoginDTO;

public interface UserServices{
	
	//public Boolean userExists(String email);
	//public int userValidation(String email, String inPass);
	//public String userLogin(@RequestBody Map<String, String> body);
	public User save(UserLoginDTO userLoginDTO);
	//public UserLoginDTO save()
	//public ModelAndView viewOne(@PathVariable String email);
	//public String changePass(@RequestBody Map<String, String> body);	
}
