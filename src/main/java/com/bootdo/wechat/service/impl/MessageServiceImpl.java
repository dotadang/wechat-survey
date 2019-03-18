package com.bootdo.wechat.service.impl;

import com.bootdo.wechat.dao.FansAppDao;
import com.bootdo.wechat.dao.FansMessageDao;
import com.bootdo.wechat.domain.FansAppDO;
import com.bootdo.wechat.domain.FansMessageDO;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.bootdo.wechat.dao.MessageDao;
import com.bootdo.wechat.domain.MessageDO;
import com.bootdo.wechat.service.MessageService;



@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private FansAppDao fansAppDao;
	@Autowired
	private FansMessageDao fansMessageDao;
	
	@Override
	public MessageDO get(Long id){
		return messageDao.get(id);
	}
	
	@Override
	public List<MessageDO> list(Map<String, Object> map){
		return messageDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return messageDao.count(map);
	}
	
	@Override
	public int save(MessageDO message){
		return messageDao.save(message);
	}
	
	@Override
	public int update(MessageDO message){
		return messageDao.update(message);
	}
	
	@Override
	public int remove(Long id){
		return messageDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return messageDao.batchRemove(ids);
	}

	@Override
	public void saveMsgOfFans(WxMpXmlMessage wxMessage) {
		MessageDO msg = new MessageDO();
		msg.setMsgtype(wxMessage.getMsgType());
		msg.setCreated(new Date());
		msg.setMsguid(UUID.randomUUID().toString().replaceAll("-",""));
		msg.setUpdated(new Date());
		msg.setModificationnum(1);
		switch (wxMessage.getMsgType()){
			case  WxConsts.CUSTOM_MSG_TEXT:
				msg.setContent(wxMessage.getContent());
				break;
			case WxConsts.CUSTOM_MSG_IMAGE:
				msg.setContent(wxMessage.getPicUrl());
				break;
		}

		messageDao.save(msg);
		//根据openid查询粉丝
		FansAppDO fansApp = fansAppDao.findFansAppByOpenId(wxMessage.getFromUser());
		// System.out.println(fansApp);
		FansMessageDO fms = new FansMessageDO();
		fms.setAppuid(wxMessage.getFromUser());
		fms.setFansuid(fansApp.getFansId());
		fms.setCreated(msg.getCreated());
		fms.setUpdated(msg.getUpdated());
		fms.setModificationnum(1);
		fms.setMsgid(msg.getMsguid());
		fansMessageDao.save(fms);


	}


}
