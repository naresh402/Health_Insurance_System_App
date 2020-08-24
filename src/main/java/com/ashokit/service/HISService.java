package com.ashokit.service;

import java.util.List;

import com.ashokit.model.HISCreateAccountBinding;

public interface HISService {
	
	
	public Boolean saveHISUserDetails(HISCreateAccountBinding hb);
	
	public List<HISCreateAccountBinding> getAllHISData();
	
	public HISCreateAccountBinding getHisUserById(Integer uId);
	
	public Boolean deleteById(Integer uId);
	
	

}
