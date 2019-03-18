package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 微信公众号
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-08 18:55:24
 */
public class ApplicationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//公众号ID
	private String appUid;
	//公众号名称
	private String appName;
	//微信appid
	private String appAppid;
	//微信secret
	private String appAppsecret;
	//团队ID
	private String teamId;
	//类型
	private String description;
	//创建时间
	private Date created;
	//修改时间
	private Date updated;
	//创建人
	private String createdBy;
	//修改人
	private String updatedBy;
	//修改次数
	private Integer modificationNum;

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
	 * 设置：公众号ID
	 */
	public void setAppUid(String appUid) {
		this.appUid = appUid;
	}
	/**
	 * 获取：公众号ID
	 */
	public String getAppUid() {
		return appUid;
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
	 * 设置：微信appid
	 */
	public void setAppAppid(String appAppid) {
		this.appAppid = appAppid;
	}
	/**
	 * 获取：微信appid
	 */
	public String getAppAppid() {
		return appAppid;
	}
	/**
	 * 设置：微信secret
	 */
	public void setAppAppsecret(String appAppsecret) {
		this.appAppsecret = appAppsecret;
	}
	/**
	 * 获取：微信secret
	 */
	public String getAppAppsecret() {
		return appAppsecret;
	}
	/**
	 * 设置：团队ID
	 */
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	/**
	 * 获取：团队ID
	 */
	public String getTeamId() {
		return teamId;
	}
	/**
	 * 设置：类型
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：类型
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
	 * 设置：创建人
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdatedBy() {
		return updatedBy;
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
}
