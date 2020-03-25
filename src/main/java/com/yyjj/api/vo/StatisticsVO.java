package com.yyjj.api.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsVO {
	/**
	 * 入住数量
	 */
	private Integer companyCount;
	
	/**
	 * 成功投递
	 */
	private Integer offerCount;
	
	/**
	 * 新增用户
	 */
	private Integer newUserCount;
	
	/**
	 * 访问量
	 */
	private Integer PV;
}
