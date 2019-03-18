package com.bootdo.wechat.service;

import com.bootdo.wechat.domain.MpMessageDO;

import java.util.List;
import java.util.Map;

/**
 * 公众号消息
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
public interface MpMessageService {
	
	MpMessageDO get(Long id);
	
	List<MpMessageDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MpMessageDO mpMessage);
	
	int update(MpMessageDO mpMessage);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
