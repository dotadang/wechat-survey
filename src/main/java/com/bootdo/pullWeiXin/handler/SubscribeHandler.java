package com.bootdo.pullWeiXin.handler;

import com.bootdo.pullWeiXin.builder.TextBuilder;
import com.bootdo.pullWeiXin.service.SaveUserWxInfoService;

import com.bootdo.wechat.domain.FansAppDO;
import com.bootdo.wechat.domain.FansDO;
import com.bootdo.wechat.service.FansAppService;
import com.bootdo.wechat.service.FansService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class SubscribeHandler extends AbstractHandler {
	@Autowired
	private SaveUserWxInfoService saveUserWxInfoService;
	@Autowired
    private FansService fansService;
	@Autowired
    private FansAppService fansAppService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

        // 获取微信用户基本信息
        WxMpUser userWxInfo = weixinService.getUserService()
                .userInfo(wxMessage.getFromUser(), null);

        if (userWxInfo != null) {
            // TODO 可以添加关注用户到本地
            this.logger.info(userWxInfo.toString());
            String openId = userWxInfo.getOpenId();
            FansAppDO fansApp = fansAppService.findByOpendId(openId);
            if (fansApp == null){
                /*Fans fans = new Fans();
                fans.setCity(userWxInfo.getCity());
                fans.setCountry(userWxInfo.getCountry());
                fans.setFanspicture(userWxInfo.getHeadImgUrl());
                fans.setFansnickname(userWxInfo.getNickname());
                fans.setFansuid(UUID.randomUUID().toString().replaceAll("-",""));
                fans.setProvince(userWxInfo.getProvince());
                fans.setFanssex(userWxInfo.getSex());
                fans.setFollowtime(ZonedDateTime.now());
                fans.setCreated(ZonedDateTime.now());
                fans.setUpdated(ZonedDateTime.now());*/
                FansDO fans =  saveFans(userWxInfo);
                fansService.save(fans);
                //向fans-app表中插入数据
                /*FansApp app = new FansApp();
                app.setAppid(wxMessage.getToUser());
                app.setOpenid(userWxInfo.getOpenId());
                app.setFansid(fans.getFansuid());
                app.setCreated(ZonedDateTime.now());
                app.setUpdated(ZonedDateTime.now());
                app.setModificationnum(1);*/
                FansAppDO app = saveFansApp(wxMessage,userWxInfo,fans);
                fansAppService.save(app);
            }else {
                //修改登录时间和粉丝状态
                fansAppService.updateStatus(fansApp.getFansId(),fansApp.getModificationNum());
            }


        }
            


        WxMpXmlOutMessage responseResult = null;
        try {
            responseResult = handleSpecial(wxMessage);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        if (responseResult != null) {
            return responseResult;
        }

        try {
            return new TextBuilder().build("感谢关注测试微信号", wxMessage, weixinService);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
            throws Exception {
        //TODO
        System.out.println("扫码关注");
        return null;
    }

    private FansDO saveFans(WxMpUser userWxInfo){
        FansDO fans = new FansDO();
        fans.setCity(userWxInfo.getCity());
        fans.setCountry(userWxInfo.getCountry());
        fans.setFansPicture(userWxInfo.getHeadImgUrl());
        fans.setFansNickname(userWxInfo.getNickname());
        fans.setFansUid(UUID.randomUUID().toString().replaceAll("-",""));
        fans.setProvince(userWxInfo.getProvince());
        fans.setFansSex(userWxInfo.getSex());
        fans.setCreated(new Date());
        fans.setUpdated(new Date());
        fans.setModificationNum(1);
        return fans;
    }
    private FansAppDO saveFansApp(WxMpXmlMessage wxMessage,WxMpUser userWxInfo,FansDO fans){
        FansAppDO app = new FansAppDO();
        app.setAppId(wxMessage.getToUser());
        app.setOpenid(userWxInfo.getOpenId());
        app.setFansId(fans.getFansUid());
        app.setUnionid(userWxInfo.getUnionId());
        app.setCreated(new Date());
        app.setUpdated(new Date());
        app.setModificationNum(1);
        app.setIsFans(1);
        app.setFollowTime(new Date());
        return app;
    }
}
