package com.bootdo.survey.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-04-16 11:06:17
 */
public class StudyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//微信openid
	private String openid;
	//有多少个孩子
	private Integer childcnt;
	//
	private String childage;
	// 您计划将来孩子接受何种高等教育？
	private String education;
	private String eduinput;
	//您预计每位孩子高等教育每年花费预算（人民币等值）？
	private Integer cost;
	// 您准备该预算的财务规划？
	private String finance;
	private String fininput;
	//您是否有海外资产配置？如有，为何种形式
	private String asset;
	private String assetinput;
	//关于孩子的留学资金准备，您最想了解什么？
	private String otherinfo;
	//称呼
	private String name;
	//电话
	private String tel;
	//邮箱
	private String email;
	//
	private Date createdate;
	//
	private Date updatedate;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：微信openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：微信openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：有多少个孩子
	 */
	public void setChildcnt(Integer childcnt) {
		this.childcnt = childcnt;
	}
	/**
	 * 获取：有多少个孩子
	 */
	public Integer getChildcnt() {
		return childcnt;
	}
	/**
	 * 设置：
	 */
	public void setChildage(String childage) {
		this.childage = childage;
	}
	/**
	 * 获取：
	 */
	public String getChildage() {
		return childage;
	}
	/**
	 * 设置： 您计划将来孩子接受何种高等教育？
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取： 您计划将来孩子接受何种高等教育？
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：您预计每位孩子高等教育每年花费预算（人民币等值）？
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	/**
	 * 获取：您预计每位孩子高等教育每年花费预算（人民币等值）？
	 */
	public Integer getCost() {
		return cost;
	}
	/**
	 * 设置： 您准备该预算的财务规划？
	 */
	public void setFinance(String finance) {
		this.finance = finance;
	}
	/**
	 * 获取： 您准备该预算的财务规划？
	 */
	public String getFinance() {
		return finance;
	}
	/**
	 * 设置：您是否有海外资产配置？如有，为何种形式
	 */
	public void setAsset(String asset) {
		this.asset = asset;
	}
	/**
	 * 获取：您是否有海外资产配置？如有，为何种形式
	 */
	public String getAsset() {
		return asset;
	}
	/**
	 * 设置：关于孩子的留学资金准备，您最想了解什么？
	 */
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	/**
	 * 获取：关于孩子的留学资金准备，您最想了解什么？
	 */
	public String getOtherinfo() {
		return otherinfo;
	}
	/**
	 * 设置：称呼
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：称呼
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	public String getAssetinput() {
		return assetinput;
	}
	public void setAssetinput(String assetinput) {
		this.assetinput = assetinput;
	}
	public String getFininput() {
		return fininput;
	}
	public void setFininput(String fininput) {
		this.fininput = fininput;
	}
	public String getEduinput() {
		return eduinput;
	}
	public void setEduinput(String eduinput) {
		this.eduinput = eduinput;
	}
}
