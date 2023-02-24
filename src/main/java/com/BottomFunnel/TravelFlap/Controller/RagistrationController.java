package com.BottomFunnel.TravelFlap.Controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.BottomFunnel.TravelFlap.Model.User;
import com.BottomFunnel.TravelFlap.Repository.UserDao;
import com.BottomFunnel.TravelFlap.Service.UserRegistrationServiceImp;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ragistration")
public class RagistrationController {
	 @Autowired 
		private UserRegistrationServiceImp userRegistrationServiceImp;
	
	 @Autowired
	 private UserDao userDao;

	 private User user;
	@PostMapping("/process_register")
    public String processRegister(HttpServletRequest request,@RequestBody User user)
            throws UnsupportedEncodingException, MessagingException {
		this.user=user;
		
		userRegistrationServiceImp.register(user, getSiteURL(request));       
        return "register_success";
    }
	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
		System.out.println("-----------------------------------------------a------------------------------------------------------------"
				+ "");
	    if (userRegistrationServiceImp.verify(code)) {
	    	userDao.save(user);
	        return "<div class=\"container text-center\">\r\n"
	        		+ "    <h3>Congratulations, your account has been verified.</h3>\r\n"
	        		+ "    <h4><a th:href=\"/@{/login}\">Click here to Login</a></h4>\r\n"
	        		+ "</div>";
	    } else {
	        return "verify_fail";
	    }
	}
     
    private String getSiteURL(HttpServletRequest request) {
    	System.out.println(request);
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }  
}
