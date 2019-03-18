package com.bootdo.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wechat.dao.TeamDao;
import com.bootdo.wechat.domain.TeamDO;
import com.bootdo.wechat.service.TeamService;



@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao teamDao;
	
	@Override
	public TeamDO get(Long id){
		return teamDao.get(id);
	}
	
	@Override
	public List<TeamDO> list(Map<String, Object> map){
		return teamDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return teamDao.count(map);
	}
	
	@Override
	public int save(TeamDO team){
		return teamDao.save(team);
	}
	
	@Override
	public int update(TeamDO team){
		return teamDao.update(team);
	}
	
	@Override
	public int remove(Long id){
		return teamDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return teamDao.batchRemove(ids);
	}
	
}
