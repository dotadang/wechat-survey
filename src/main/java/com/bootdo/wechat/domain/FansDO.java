package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 粉丝信息表
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-09 15:33:54
 */
public class FansDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//粉丝表ID
	private Long id;
	//粉丝业务ID
	private String fansUid;
	//昵称
	private String fansNickname;
	//头像
	private String fansPicture;
	//性别
	private String fansSex;
	//国家
	private String country;
	//省会
	private String province;
	//城市
	private String city;
	//备注
	private String comment;
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
	 * 设置：粉丝表ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：粉丝表ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：粉丝业务ID
	 */
	public void setFansUid(String fansUid) {
		this.fansUid = fansUid;
	}
	/**
	 * 获取：粉丝业务ID
	 */
	public String getFansUid() {
		return fansUid;
	}
	/**
	 * 设置：昵称
	 */
	public void setFansNickname(String fansNickname) {
		this.fansNickname = fansNickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getFansNickname() {
		return fansNickname;
	}
	/**
	 * 设置：头像
	 */
	public void setFansPicture(String fansPicture) {
		this.fansPicture = fansPicture;
	}
	/**
	 * 获取：头像
	 */
	public String getFansPicture() {
		return fansPicture;
	}
	/**
	 * 设置：性别
	 */
	public void setFansSex(String fansSex) {
		this.fansSex = fansSex;
	}
	/**
	 * 获取：性别
	 */
	public String getFansSex() {
		return fansSex;
	}
	/**
	 * 设置：国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：省会
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省会
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：备注
	 */
	public String getComment() {
		return comment;
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
