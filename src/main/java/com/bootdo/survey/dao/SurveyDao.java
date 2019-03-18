package com.bootdo.survey.dao;

import com.bootdo.survey.domain.SurveyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 问卷结果
 * @author dotadang
 * @email 1992lcg@163.com
 * @date 2019-02-12 14:44:38
 */
@Mapper
public interface SurveyDao {

	SurveyDO get(Integer id);
	
	List<SurveyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SurveyDO survey);
	
	int update(SurveyDO survey);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
