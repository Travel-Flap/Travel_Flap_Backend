package com.BottomFunnel.TravelFlap.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.BottomFunnel.TravelFlap.Model.Registrationverification;
import com.BottomFunnel.TravelFlap.Model.User;
import com.BottomFunnel.TravelFlap.Repository.RegistrationVerificationRepo;
import com.BottomFunnel.TravelFlap.Repository.UserDao;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import net.bytebuddy.utility.RandomString;

@Service
public class UserRegistrationServiceImp implements UserRegistrationService{
	   
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private RegistrationVerificationRepo registrationVerificationRepo;
    
    
    @Autowired
    private UserDao userDao;

@Override
public void register(User user, String siteURL) throws MailException, UnsupportedEncodingException, MessagingException {
	
	     
	    String randomCode = RandomString.make(64);
	    
	    Registrationverification registrationverification=new  Registrationverification();
	    registrationverification.setVerificationCode(randomCode);
	    registrationverification.setEnabled("false");
	     
	    registrationVerificationRepo.save(registrationverification);
	     System.out.println("rigistration complete");
	    
	    sendVerificationEmail(user, siteURL,registrationverification);
	
}

@Override
public void sendVerificationEmail(User user, String siteURL,Registrationverification registrationCode) throws UnsupportedEncodingException, MessagingException, MailException  {
	 
Optional<User>	user1=userDao.findByEmail(user.getEmail());
Optional<User>	user2=userDao.findByMobileNo(user.getMobileNo());

if(user1.isPresent()) {
	throw new RuntimeException("Email is already Registered"); 
}else if(user2.isPresent()) {
	throw new RuntimeException("Mobile Number is already Registered"); 
}
	
	
	String toAddress = user.getEmail();
	    String fromAddress = "neermalviya369@gmail.com";
	    String senderName = "Bottom Funnel";
	    String subject = "Please verify your registration";
	    String content = "Dear [[name]],<br>"
	            + "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "Your company name.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", user.getName());
	    String verifyURL = siteURL+"/ragistration"+"/verify?code="+registrationCode.getVerificationCode();

	    content = content.replace("[[URL]]", verifyURL);
	     
	    helper.setText(content,true);
	     
	    mailSender.send(message);
	System.out.println("Msg sent");
}

@Override
public boolean verify(String verificationCode) {
Optional<Registrationverification> registrationverification	=registrationVerificationRepo.findByverificationCode(verificationCode);
if(registrationverification.isPresent()) {
	Registrationverification userverify=registrationverification.get();
	userverify.setEnabled("true");
	userverify.setVerificationCode(null);
	registrationVerificationRepo.save(userverify);
	return true;
}
return false;
}

}
