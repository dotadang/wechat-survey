package com.bootdo.survey.service;

import com.bootdo.survey.domain.SurveyDO;

import java.util.List;
import java.util.Map;

/**
 * 问卷结果
 * 
 * @author dotadang
 * @email 1992lcg@163.com
 * @date 2019-02-12 14:44:38
 */
public interface SurveyService {
	
	SurveyDO get(Integer id);
	
	List<SurveyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SurveyDO survey);
	
	int update(SurveyDO survey);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
