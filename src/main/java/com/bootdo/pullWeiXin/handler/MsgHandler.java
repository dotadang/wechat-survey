package com.bootdo.pullWeiXin.handler;

import com.bootdo.pullWeiXin.builder.TextBuilder;
import com.bootdo.pullWeiXin.utils.JsonUtils;
import com.bootdo.pullWeiXin.utils.downLoadUtil;
import com.bootdo.wechat.service.MessageService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    private MessageService messageService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        /*if (!wxMessage.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
            //TODO 可以选择将消息保存到本地
        }*/
        String content = null;
        switch(wxMessage.getMsgType()){
            case WxConsts.CUSTOM_MSG_TEXT :
                System.out.println(wxMessage.toString());
                content = "已保存，文字回复功能尚未开发完成，敬请谅解！";
                messageService.saveMsgOfFans(wxMessage);
                break;

            case WxConsts.CUSTOM_MSG_IMAGE :
                System.out.println(wxMessage.toString());
                String fileName = UUID.randomUUID()+".JPG";
                String savePath = "E:\\htm\\"+wxMessage.getFromUser()+"\\";
                try {
                    downLoadUtil.downLoadFromUrl(wxMessage.getPicUrl(), fileName,savePath);
                }catch (Exception e){
                    logger.error("download  Defeat of  picture : {}",wxMessage.getPicUrl());
                    e.printStackTrace();
                }
                wxMessage.setPicUrl(savePath+fileName);
                messageService.saveMsgOfFans(wxMessage);
                content = "已保存，图片回复功能尚未开发完成，敬请谅解！";
                break;

        }


        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        //TODO 组装回复消息
        //String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);

        return new TextBuilder().build(content, wxMessage, weixinService);

    }

}
