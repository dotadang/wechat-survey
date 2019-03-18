package com.bootdo.wechat.dao;

import com.bootdo.wechat.domain.ApplicationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 微信公众号
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-08 18:55:24
 */
@Mapper
public interface ApplicationDao {

	ApplicationDO get(Long id);
	
	List<ApplicationDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ApplicationDO application);
	
	int update(ApplicationDO application);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
