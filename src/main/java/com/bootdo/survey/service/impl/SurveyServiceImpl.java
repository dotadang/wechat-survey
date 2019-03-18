package com.bootdo.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.survey.dao.SurveyDao;
import com.bootdo.survey.domain.SurveyDO;
import com.bootdo.survey.service.SurveyService;



@Service
public class SurveyServiceImpl implements SurveyService {
	@Autowired
	private SurveyDao surveyDao;
	
	@Override
	public SurveyDO get(Integer id){
		return surveyDao.get(id);
	}
	
	@Override
	public List<SurveyDO> list(Map<String, Object> map){
		return surveyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return surveyDao.count(map);
	}
	
	@Override
	public int save(SurveyDO survey){
		Date now = new Date();
		survey.setCreated(now);
		survey.setUpdated(now);
		survey.calcScore();
		return surveyDao.save(survey);
	}
	
	@Override
	public int update(SurveyDO survey){
		return surveyDao.update(survey);
	}
	
	@Override
	public int remove(Integer id){
		return surveyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return surveyDao.batchRemove(ids);
	}
	
}
