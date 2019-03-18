package com.bootdo.wechat.service.impl;

import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.FansDao;
import com.bootdo.wechat.domain.FansDO;
import com.bootdo.wechat.service.FansService;



@Service
public class FansServiceImpl implements FansService{
	@Autowired
	private FansDao fansDao;
	
	@Override
	public FansDO get(Long id){
		return fansDao.get(id);
	}
	
	@Override
	public List<FansDO> list(Map<String, Object> map){
		return fansDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fansDao.count(map);
	}
	
	@Override
	public int save(FansDO fans){
		return fansDao.save(fans);
	}
	
	@Override
	public int update(FansDO fans){
		return fansDao.update(fans);
	}
	
	@Override
	public int remove(Long id){
		return fansDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return fansDao.batchRemove(ids);
	}

	@Override
	public int saveUserWxInfo(WxMpUser userWxInfo) {

		return fansDao.saveUserWxInfo(userWxInfo);
	}

}
