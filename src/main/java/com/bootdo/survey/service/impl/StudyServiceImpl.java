package com.bootdo.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.survey.dao.StudyDao;
import com.bootdo.survey.domain.StudyDO;
import com.bootdo.survey.service.StudyService;



@Service
public class StudyServiceImpl implements StudyService {
	@Autowired
	private StudyDao studyDao;
	
	@Override
	public StudyDO get(Integer id){
		return studyDao.get(id);
	}
	
	@Override
	public List<StudyDO> list(Map<String, Object> map){
		return studyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return studyDao.count(map);
	}
	
	@Override
	public int save(StudyDO study){
		Date now = new Date();
		study.setCreatedate(now);
		study.setUpdatedate(now);
		return studyDao.save(study);
	}
	
	@Override
	public int update(StudyDO study){
		return studyDao.update(study);
	}
	
	@Override
	public int remove(Integer id){
		return studyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return studyDao.batchRemove(ids);
	}
	
}
