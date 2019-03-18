package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 消息记录库
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:23:03
 */
public class MessageDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//消息业务ID
	private String msguid;
	//消息类型
	private String msgtype;
	//消息内容
	private String content;
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
	 * 设置：消息业务ID
	 */
	public void setMsguid(String msguid) {
		this.msguid = msguid;
	}
	/**
	 * 获取：消息业务ID
	 */
	public String getMsguid() {
		return msguid;
	}
	/**
	 * 设置：消息类型
	 */
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	/**
	 * 获取：消息类型
	 */
	public String getMsgtype() {
		return msgtype;
	}
	/**
	 * 设置：消息内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：消息内容
	 */
	public String getContent() {
		return content;
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
