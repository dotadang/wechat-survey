package com.bootdo.wechat.dao;

import com.bootdo.wechat.domain.FansAppDO;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import javax.xml.crypto.Data;

/**
 * 粉丝公众号关联表
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:33:54
 */
@Mapper
public interface FansAppDao {

	FansAppDO get(Long id);
	
	List<FansAppDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(FansAppDO fansApp);
	
	int update(FansAppDO fansApp);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	FansAppDO findFansAppByOpenId(String openid);

	int updateForstatus(String openid,Date time);

	int updateStatus(Integer status, Date time,Integer num ,String fansId);
}
