package com.bootdo.wechat.service;

import com.bootdo.wechat.domain.FansMessageDO;

import java.util.List;
import java.util.Map;

/**
 * 粉丝消息表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
public interface FansMessageService {
	
	FansMessageDO get(Long id);
	
	List<FansMessageDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FansMessageDO fansMessage);
	
	int update(FansMessageDO fansMessage);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
