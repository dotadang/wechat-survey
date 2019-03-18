package com.bootdo.wechat.dao;

import com.bootdo.wechat.domain.TeamDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 团队/组织
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-08 18:55:24
 */
@Mapper
public interface TeamDao {

	TeamDO get(Long id);
	
	List<TeamDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TeamDO team);
	
	int update(TeamDO team);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
