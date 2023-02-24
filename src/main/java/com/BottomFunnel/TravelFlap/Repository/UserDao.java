package com.BottomFunnel.TravelFlap.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BottomFunnel.TravelFlap.Model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	public Optional<User> findByMobileNo(String mobileNo);
	public Optional<User> findByEmail(String email);
	
}
