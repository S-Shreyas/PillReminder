package com.ssn59.pillreminder.userlogindao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssn59.pillreminder.User;

@Repository
public interface UserLoginDAO extends JpaRepository<User, String> {

	User findByEmail(String email);
	Boolean existsByEmail(String email);
	Boolean existsByPhone(String phone);
}