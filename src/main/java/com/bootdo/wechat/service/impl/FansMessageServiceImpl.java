package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.FansMessageDao;
import com.bootdo.wechat.domain.FansMessageDO;
import com.bootdo.wechat.service.FansMessageService;



@Service
public class FansMessageServiceImpl implements FansMessageService {
	@Autowired
	private FansMessageDao fansMessageDao;
	
	@Override
	public FansMessageDO get(Long id){
		return fansMessageDao.get(id);
	}
	
	@Override
	public List<FansMessageDO> list(Map<String, Object> map){
		return fansMessageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fansMessageDao.count(map);
	}
	
	@Override
	public int save(FansMessageDO fansMessage){
		return fansMessageDao.save(fansMessage);
	}
	
	@Override
	public int update(FansMessageDO fansMessage){
		return fansMessageDao.update(fansMessage);
	}
	
	@Override
	public int remove(Long id){
		return fansMessageDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return fansMessageDao.batchRemove(ids);
	}
	
}
