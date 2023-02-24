package com.BottomFunnel.TravelFlap.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BottomFunnel.TravelFlap.Model.Registrationverification;
import com.BottomFunnel.TravelFlap.Model.User;

public interface RegistrationVerificationRepo extends JpaRepository<Registrationverification, Integer> {
	public Optional<Registrationverification> findByverificationCode(String code);
	
	
}
