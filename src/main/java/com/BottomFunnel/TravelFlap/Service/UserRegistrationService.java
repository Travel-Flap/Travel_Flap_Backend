package com.BottomFunnel.TravelFlap.Service;



import java.io.UnsupportedEncodingException;

import org.springframework.mail.MailException;

import com.BottomFunnel.TravelFlap.Model.Registrationverification;
import com.BottomFunnel.TravelFlap.Model.User;

import jakarta.mail.MessagingException;



public interface UserRegistrationService {
	 public void register(User user, String siteURL) throws MailException, UnsupportedEncodingException, MessagingException ;
	 public void sendVerificationEmail(User user, String siteURL,Registrationverification registrationCode) throws UnsupportedEncodingException, MessagingException  ;
	 public boolean verify(String verificationCode);
}
