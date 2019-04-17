package com.bootdo.survey.dao;

import com.bootdo.survey.domain.StudyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-16 11:06:17
 */
@Mapper
public interface StudyDao {

	StudyDO get(Integer id);
	
	List<StudyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(StudyDO study);
	
	int update(StudyDO study);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
