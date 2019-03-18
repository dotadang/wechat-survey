package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.ApplicationDao;
import com.bootdo.wechat.domain.ApplicationDO;
import com.bootdo.wechat.service.ApplicationService;



@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationDao applicationDao;
	
	@Override
	public ApplicationDO get(Long id){
		return applicationDao.get(id);
	}
	
	@Override
	public List<ApplicationDO> list(Map<String, Object> map){
		return applicationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return applicationDao.count(map);
	}
	
	@Override
	public int save(ApplicationDO application){
		return applicationDao.save(application);
	}
	
	@Override
	public int update(ApplicationDO application){
		return applicationDao.update(application);
	}
	
	@Override
	public int remove(Long id){
		return applicationDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return applicationDao.batchRemove(ids);
	}
	
}
