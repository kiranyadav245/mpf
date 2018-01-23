package com.murari.service.impl.transaction;

import org.springframework.stereotype.Service;

import com.murari.service.transation.SmsService;

@Service
public class SmsServiceImpl implements SmsService {

	@Override
	public void sendinStoneDetails(long id) {
		// TODO Auto-generated method stub
		System.out.println("sms stone in");
		
	}
	
}
