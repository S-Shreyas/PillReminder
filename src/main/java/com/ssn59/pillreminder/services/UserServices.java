package com.ssn59.pillreminder.services;

import com.ssn59.pillreminder.User;
import com.ssn59.pillreminder.userlogindto.UserLoginDTO;

public interface UserServices{
	
	public String userLogin(UserLoginDTO userLoginDTO);
	public User save(UserLoginDTO userLoginDTO);
	public Boolean userExist(String email);
	public Boolean phoneExists(String phone);
	public Boolean userValidation(String email, String pass);
	public User viewCurrentPerson(String email);
	public Boolean verifyPass(String pass, String email);
}
	
