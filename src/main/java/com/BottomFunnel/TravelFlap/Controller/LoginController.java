package com.BottomFunnel.TravelFlap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.BottomFunnel.TravelFlap.Model.UserDtoEmail;
import com.BottomFunnel.TravelFlap.Model.UserDtoMobile;

import com.BottomFunnel.TravelFlap.Service.LoginServicesImp;

@RestController
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private LoginServicesImp loginServicesImp;
	

	
	
		@PostMapping("/mobile")
		public String logInUser(@RequestBody UserDtoMobile userDtoMobile) throws Exception {
			return loginServicesImp.userLoginWithMobile(userDtoMobile);
		}
	
	
		@PostMapping("/Emailid")
		public String logInUser(@RequestBody UserDtoEmail userDtoEmail) throws Exception {
			
			return loginServicesImp.userLoginWithEmail(userDtoEmail);
		}
		
	
		@GetMapping("userLogout")
		public String userLogout(@RequestParam(required = false) String userId) {
			return loginServicesImp.userLogout(userId);
			
		}
}
