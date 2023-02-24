package com.BottomFunnel.TravelFlap.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BottomFunnel.TravelFlap.Model.CurrentUserSession;

@Repository
public interface CurrentUserSessionDao extends  JpaRepository<CurrentUserSession, Integer>{
	public Optional<CurrentUserSession> findByUserId(String userID);
	
}
