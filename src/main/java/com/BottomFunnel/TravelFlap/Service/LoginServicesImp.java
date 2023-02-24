package com.BottomFunnel.TravelFlap.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BottomFunnel.TravelFlap.Model.CurrentUserSession;
import com.BottomFunnel.TravelFlap.Model.User;
import com.BottomFunnel.TravelFlap.Model.UserDtoEmail;
import com.BottomFunnel.TravelFlap.Model.UserDtoMobile;
import com.BottomFunnel.TravelFlap.Repository.CurrentUserSessionDao;
import com.BottomFunnel.TravelFlap.Repository.UserDao;


@Service
public class LoginServicesImp implements LoginServices {

	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String userLoginWithMobile(UserDtoMobile userDtoMobile) {
		
Optional<User> opt= userDao.findByMobileNo(userDtoMobile.getMobileNo());
		
		if(!opt.isPresent()) {
			throw new RuntimeException("Please enter valid Mobile number!");
		}
		
		User user1= opt.get();
		Integer userId = user1.getId();
if(user1.getPassword().equals(userDtoMobile.getPassword())) {
		CurrentUserSession UserSession=new CurrentUserSession(userDtoMobile.getMobileNo(),"login",LocalDateTime.now());
			currentUserSessionDao.save(UserSession);
            return "Login Succesfully" ;
			
		}
		
			throw new RuntimeException("Please Enter valid password.");
		
	}

	@Override
	public String userLoginWithEmail(UserDtoEmail userDtoEmail) {
		
Optional<User> opt= userDao.findByEmail(userDtoEmail.getEmail());

    if(!opt.isPresent()) {
    	return "";
    }
		User user1= opt.get();
		
		Integer userId = user1.getId();
		
		
		
		
		if(user1.getPassword().equals(userDtoEmail.getPassword())) {
		Optional<CurrentUserSession> session=	currentUserSessionDao.findByUserId(user1.getMobileNo());
			if(!session.isPresent()) {
				CurrentUserSession UserSession=new CurrentUserSession(user1.getMobileNo(),"login",LocalDateTime.now());
				
				currentUserSessionDao.save(UserSession);
			}
			session.get().setLocalDateTime(LocalDateTime.now());
			currentUserSessionDao.save(session.get());
			return "Login Successfully";
			
		}
		else {
			throw new RuntimeException( "Please Enter valid password.");
		}
	}

	@Override
	public String userLogout(String userId) {
		Optional<CurrentUserSession>  currentUserSession=currentUserSessionDao.findByUserId(userId);
		currentUserSession.get().setStatus("logout");
		currentUserSessionDao.save(currentUserSession.get());
		return "Log Out Successfully";
	}

}
