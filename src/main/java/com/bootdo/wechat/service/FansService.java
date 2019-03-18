package com.bootdo.wechat.service;

import com.bootdo.wechat.domain.FansDO;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.List;
import java.util.Map;

/**
 * 粉丝信息表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:33:54
 */
public interface FansService {
	
	FansDO get(Long id);
	
	List<FansDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FansDO fans);
	
	int update(FansDO fans);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	int saveUserWxInfo(WxMpUser userWxInfo);
}
