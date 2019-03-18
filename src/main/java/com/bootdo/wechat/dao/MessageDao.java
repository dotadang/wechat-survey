package com.bootdo.wechat.dao;

import com.bootdo.wechat.domain.MessageDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 消息记录库
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
@Mapper
public interface MessageDao {

	MessageDO get(Long id);
	
	List<MessageDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MessageDO message);
	
	int update(MessageDO message);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
