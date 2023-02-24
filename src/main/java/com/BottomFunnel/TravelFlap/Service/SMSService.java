package com.BottomFunnel.TravelFlap.Service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.BottomFunnel.TravelFlap.Model.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SMSService {
	 private final String ACCOUNT_SID ="AC4557b47967dd0d5d2b62df88c9683e56";

	    private final String AUTH_TOKEN = "0351da97aadecb483c879a1670ca4a6c";

	    private final String FROM_NUMBER = "+12708178467";

	    public void send(SMS sms) {
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
System.out.println(sms.getMessage()+" "+sms.getTo());
	        Message message = Message.creator(new com.twilio.type.PhoneNumber(sms.getTo()), new com.twilio.type.PhoneNumber(FROM_NUMBER), sms.getMessage())
	                .create();
	        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

	    }

	    public void receive(MultiValueMap<String, String> smscallback) {
	    }
	
}

