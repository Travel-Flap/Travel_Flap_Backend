package com.BottomFunnel.TravelFlap.Service;

import com.BottomFunnel.TravelFlap.Model.UserDtoEmail;
import com.BottomFunnel.TravelFlap.Model.UserDtoMobile;

public interface LoginServices {
	public String userLoginWithMobile(UserDtoMobile userDtoMobile) ;
	public String userLoginWithEmail(UserDtoEmail userDtoEmail);
	public String userLogout(String userId);
}
