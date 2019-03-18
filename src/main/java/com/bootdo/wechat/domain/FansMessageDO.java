package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 粉丝消息表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
public class FansMessageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//粉丝ID
	private String fansuid;
	//公众号ID
	private String appuid;
	//消息ID
	private String msgid;
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
	 * 设置：粉丝ID
	 */
	public void setFansuid(String fansuid) {
		this.fansuid = fansuid;
	}
	/**
	 * 获取：粉丝ID
	 */
	public String getFansuid() {
		return fansuid;
	}
	/**
	 * 设置：公众号ID
	 */
	public void setAppuid(String appuid) {
		this.appuid = appuid;
	}
	/**
	 * 获取：公众号ID
	 */
	public String getAppuid() {
		return appuid;
	}
	/**
	 * 设置：消息ID
	 */
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	/**
	 * 获取：消息ID
	 */
	public String getMsgid() {
		return msgid;
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
