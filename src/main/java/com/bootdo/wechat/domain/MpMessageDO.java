package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 公众号消息
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
public class MpMessageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//公众号消息ID
	private String mpmessageuid;
	//公众号ID
	private String appid;
	//消息记录ID
	private String msgid;
	//消息条数
	private Integer msgtotal;
	//阅读量
	private Integer readnum;
	//场景
	private String scenes;
	//创建时间
	private Date created;
	//修改时间
	private Date updated;
	//创建人
	private String createdby;
	//修改人
	private String updatedby;
	//修改次数
	private Integer modificationnum;

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
	 * 设置：公众号消息ID
	 */
	public void setMpmessageuid(String mpmessageuid) {
		this.mpmessageuid = mpmessageuid;
	}
	/**
	 * 获取：公众号消息ID
	 */
	public String getMpmessageuid() {
		return mpmessageuid;
	}
	/**
	 * 设置：公众号ID
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * 获取：公众号ID
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * 设置：消息记录ID
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	/**
	 * 获取：消息记录ID
	 */
	public String getMsgid() {
		return msgid;
	}
	/**
	 * 设置：消息条数
	 */
	public void setMsgtotal(Integer msgtotal) {
		this.msgtotal = msgtotal;
	}
	/**
	 * 获取：消息条数
	 */
	public Integer getMsgtotal() {
		return msgtotal;
	}
	/**
	 * 设置：阅读量
	 */
	public void setReadnum(Integer readnum) {
		this.readnum = readnum;
	}
	/**
	 * 获取：阅读量
	 */
	public Integer getReadnum() {
		return readnum;
	}
	/**
	 * 设置：场景
	 */
	public void setScenes(String scenes) {
		this.scenes = scenes;
	}
	/**
	 * 获取：场景
	 */
	public String getScenes() {
		return scenes;
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
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedby() {
		return createdby;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdatedby() {
		return updatedby;
	}
	/**
	 * 设置：修改次数
	 */
	public void setModificationnum(Integer modificationnum) {
		this.modificationnum = modificationnum;
	}
	/**
	 * 获取：修改次数
	 */
	public Integer getModificationnum() {
		return modificationnum;
	}
}
