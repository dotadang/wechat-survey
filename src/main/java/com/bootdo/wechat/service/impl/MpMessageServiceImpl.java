package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.MpMessageDao;
import com.bootdo.wechat.domain.MpMessageDO;
import com.bootdo.wechat.service.MpMessageService;



@Service
public class MpMessageServiceImpl implements MpMessageService {
	@Autowired
	private MpMessageDao mpMessageDao;
	
	@Override
	public MpMessageDO get(Long id){
		return mpMessageDao.get(id);
	}
	
	@Override
	public List<MpMessageDO> list(Map<String, Object> map){
		return mpMessageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return mpMessageDao.count(map);
	}
	
	@Override
	public int save(MpMessageDO mpMessage){
		return mpMessageDao.save(mpMessage);
	}
	
	@Override
	public int update(MpMessageDO mpMessage){
		return mpMessageDao.update(mpMessage);
	}
	
	@Override
	public int remove(Long id){
		return mpMessageDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return mpMessageDao.batchRemove(ids);
	}
	
}
