package com.bootdo.survey.controller;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class BasewxController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMpService wxService;

    protected String getOpenIdByOAuth2Code(String code) throws Exception {
		WxMpOAuth2AccessToken oauthToken = wxService.oauth2getAccessToken(code);
		this.logger.info("网页授权获取到的用户信息：openId={}", oauthToken.getOpenId());
		
		return oauthToken.getOpenId();
	}
    
    protected String getOauth2buildAuthorizationUrl(String url) {
    	return wxService.oauth2buildAuthorizationUrl(url, "snsapi_base", "new_emp_register");
    }
	
	protected String getRequestUrl(HttpServletRequest request) {
		return request.getRequestURL().substring(0, request.getRequestURL().lastIndexOf("/"));
	}
	
	public static boolean isMicromessengerBrowser(HttpServletRequest request) {  
	    String userAgent = request.getHeader("user-agent").toLowerCase();  
	    return userAgent.contains("micromessenger");  
	}  

}
