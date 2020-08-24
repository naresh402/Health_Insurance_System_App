package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ashokit.Entity.HISEntity;
import com.ashokit.exceptions.HISAppException;
import com.ashokit.model.HISCreateAccountBinding;
import com.ashokit.repository.HISCreateAccountRepository;

public class HISServiceImpl implements HISService {

	@Autowired
	private HISCreateAccountRepository hisRepo;
	
	@Override
	public Boolean saveHISUserDetails(HISCreateAccountBinding hb) {
		
		boolean isSaved=false;
		
		try {
			
			HISEntity hEntity=new HISEntity();
			BeanUtils.copyProperties(hb, hEntity);
			HISEntity saveEntity= hisRepo.save(hEntity);
			if(saveEntity.getUserId()!=null) {
				isSaved=true;
			}
		}
			catch (Exception e) {
			throw new HISAppException("Not Saved");
		}
		return isSaved;
		}
		
		
		
	

	@Override
	public List<HISCreateAccountBinding> getAllHISData() {
		
	//List<HISCreateAccountBinding> listData=null;
		
		try {
			//int i=10/0;
			List<HISEntity> hEntity=hisRepo.findAll();
			List<HISCreateAccountBinding> entity=new ArrayList<>();
			for(HISEntity e:hEntity) {
				HISCreateAccountBinding hisData=new HISCreateAccountBinding();
				BeanUtils.copyProperties(e, hisData);
				entity.add(hisData);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean deleteById(Integer uId) {
		
		hisRepo.deleteById(uId);
		return true;
	}





	@Override
	public HISCreateAccountBinding getHisUserById(Integer uId) {
		Optional<HISEntity> findById = hisRepo.findById(uId);
		if(findById.isPresent()) {
			HISEntity entity=findById.get();
			HISCreateAccountBinding h=new HISCreateAccountBinding();
			BeanUtils.copyProperties(entity, h);
			return h;
		}
		return null;
		
	}

}
