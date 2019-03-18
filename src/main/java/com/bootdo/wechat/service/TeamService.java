package com.bootdo.wechat.service;

import com.bootdo.wechat.domain.TeamDO;

import java.util.List;
import java.util.Map;

/**
 * 团队/组织
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-08 18:55:24
 */
public interface TeamService {
	
	TeamDO get(Long id);
	
	List<TeamDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TeamDO team);
	
	int update(TeamDO team);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
