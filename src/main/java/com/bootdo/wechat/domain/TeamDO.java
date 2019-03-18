package com.bootdo.wechat.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 团队/组织
 * 
 * @author song
 * @email 1992lcg@163.com
 * @date 2017-11-08 18:55:24
 */
public class TeamDO extends baseDo {

	
	//
	private Long id;
	//团队ID
	private String teamUid;
	//团队名称
	private String teamName;
	//省会
	private String province;
	//城市
	private String city;
	//地址
	private String area;
	//负责人
	private String principal;
	//负责人联系方式
	private String principalPhone;
	//描述
	private String description;


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
	 * 设置：团队ID
	 */
	public void setTeamUid(String teamUid) {
		this.teamUid = teamUid;
	}
	/**
	 * 获取：团队ID
	 */
	public String getTeamUid() {
		return teamUid;
	}
	/**
	 * 设置：团队名称
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * 获取：团队名称
	 */
	public String getTeamName() {
		return teamName;
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
	 * 设置：地址
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：地址
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：负责人
	 */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	/**
	 * 获取：负责人
	 */
	public String getPrincipal() {
		return principal;
	}
	/**
	 * 设置：负责人联系方式
	 */
	public void setPrincipalPhone(String principalPhone) {
		this.principalPhone = principalPhone;
	}
	/**
	 * 获取：负责人联系方式
	 */
	public String getPrincipalPhone() {
		return principalPhone;
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

}
