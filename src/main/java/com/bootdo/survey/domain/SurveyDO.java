package com.bootdo.survey.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 问卷结果
 * 
 * @author dotadang
 * @email 1992lcg@163.com
 * @date 2019-02-12 14:44:38
 */
public class SurveyDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//
	private String openid;
	//
	private Integer q1;
	//
	private Integer q2;
	//
	private Integer q3;
	//
	private Integer q4;
	//
	private Integer q5;
	//
	private String q6;
	//
	private String name;
	//
	private String mobile;
	//
	private String email;
	// 问卷结果
	private Integer score;
	//
	private Date created;
	//
	private Date updated;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
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
	 * 设置：
	 */
	public void setQ1(Integer q1) {
		this.q1 = q1;
	}

	/**
	 * 获取：
	 */
	public Integer getQ1() {
		return q1;
	}

	/**
	 * 设置：
	 */
	public void setQ2(Integer q2) {
		this.q2 = q2;
	}

	/**
	 * 获取：
	 */
	public Integer getQ2() {
		return q2;
	}

	/**
	 * 设置：
	 */
	public void setQ3(Integer q3) {
		this.q3 = q3;
	}

	/**
	 * 获取：
	 */
	public Integer getQ3() {
		return q3;
	}

	/**
	 * 设置：
	 */
	public void setQ4(Integer q4) {
		this.q4 = q4;
	}

	/**
	 * 获取：
	 */
	public Integer getQ4() {
		return q4;
	}

	/**
	 * 设置：
	 */
	public void setQ5(Integer q5) {
		this.q5 = q5;
	}

	/**
	 * 获取：
	 */
	public Integer getQ5() {
		return q5;
	}

	/**
	 * 设置：
	 */
	public void setQ6(String q6) {
		this.q6 = q6;
	}

	/**
	 * 获取：
	 */
	public String getQ6() {
		return q6;
	}

	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置：问卷结果
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * 获取：问卷结果
	 */
	public Integer getScore() {
		return score;
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

	public void calcScore() {
		int calcScore = 0;
		if (q1 != null) {
			switch (q1) {
			case 1:
				calcScore += 30;
				break;
			case 2:
				calcScore += 20;
				break;
			case 3:
				calcScore += 15;
				break;
			}
		}
		if (q2 != null) {
			switch (q2) {
			case 1:
				calcScore += 40;
				break;
			case 2:
				calcScore += 20;
				break;
			case 3:
				calcScore += 10;
				break;
			}
		}
		if (q3 != null) {
			switch (q3) {
			case 1:
				calcScore += 40;
				break;
			case 2:
				calcScore += 30;
				break;
			case 3:
				calcScore += 15;
				break;
			case 4:
				calcScore += 5;
				break;
			}
		}
		if (q4 != null) {
			switch (q4) {
			case 1:
				calcScore += 20;
				break;
			case 2:
				calcScore += 15;
				break;
			case 3:
				calcScore += 10;
				break;
			}
		}
		if (q5 != null) {
			switch (q5) {
			case 2:
				calcScore += 5;
				break;
			case 3:
				calcScore += 10;
				break;
			}
		}
		if (q6 != null) {
			String[] answers = new String[20];
			answers = q6.split(",");
			for (int i = 0; i < answers.length; i++) {
				switch (Integer.parseInt(answers[i])) {
				case 1:
					calcScore += 30;
					break;
				case 2:
					calcScore += 15;
					break;
				case 3:
					calcScore += 5;
					break;
				case 4:
					calcScore += 5;
					break;
				case 5:
					calcScore += 30;
					break;
				}
			}
		}

		this.score = calcScore;
	}
}
