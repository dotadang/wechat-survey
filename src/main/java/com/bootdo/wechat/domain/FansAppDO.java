package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 粉丝公众号关联表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:33:54
 */
public class FansAppDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//粉丝ID
	private String fansId;
	//公众号ID
	private String appId;
	//
	private String unionid;
	//
	private String openid;
	//描述
	private String description;
	//创建时间
	private Date created;
	//修改时间
	private Date updated;
	//修改次数
	private Integer modificationNum;
	//公众号名称
	private String appName;
	//是否粉丝
	private Integer isFans;
	//关注时间
	private Date followTime;
	//取关时间
	private Date unfollowTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：粉丝ID
	 */
	public void setFansId(String fansId) {
		this.fansId = fansId;
	}
	/**
	 * 获取：粉丝ID
	 */
	public String getFansId() {
		return fansId;
	}
	/**
	 * 设置：公众号ID
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：公众号ID
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	/**
	 * 获取：
	 */
	public String getUnionid() {
		return unionid;
	}
	/**
	 * 设置：
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * 设置：修改次数
	 */
	public void setModificationNum(Integer modificationNum) {
		this.modificationNum = modificationNum;
	}
	/**
	 * 获取：修改次数
	 */
	public Integer getModificationNum() {
		return modificationNum;
	}
	/**
	 * 设置：公众号名称
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * 获取：公众号名称
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * 设置：是否粉丝
	 */
	public void setIsFans(Integer isFans) {
		this.isFans = isFans;
	}
	/**
	 * 获取：是否粉丝
	 */
	public Integer getIsFans() {
		return isFans;
	}
	/**
	 * 设置：关注时间
	 */
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	/**
	 * 获取：关注时间
	 */
	public Date getFollowTime() {
		return followTime;
	}
	/**
	 * 设置：取关时间
	 */
	public void setUnfollowTime(Date unfollowTime) {
		this.unfollowTime = unfollowTime;
	}
	/**
	 * 获取：取关时间
	 */
	public Date getUnfollowTime() {
		return unfollowTime;
	}
}
