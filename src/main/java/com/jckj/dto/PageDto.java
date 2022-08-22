package com.jckj.dto;

import java.io.Serializable;

/**
 * @author: ljp
 * @description: 分页初始化对象
 * @date: 2022年8月12日 上午11:21:42
 */
public class PageDto implements Serializable {

	private static final long serialVersionUID = 5172649115384573373L;
	/**
	 * 默认每页显示数
	 */
	private static final Integer ROW = 10;
	/**
	 * 默认页码
	 */
	private static final Integer NUM = 1;
	/**
	 * 0
	 */
	private static final Integer ZERO = 0;

	/**
	 * 每页显示条数
	 */
	private Integer limit = ROW;

	/**
	 * 页码
	 */
	private Integer pageNum = NUM;

	/**
	 * sql分页起始位置
	 */
	private Integer page = ZERO;

	/**
	 * 排序 desc降序 asc升序
	 */
	private String sort;

	/**
	 * 状态
	 */
	private Integer state;
	
	/**
	 * 名称
	 */
	private String name;

	public PageDto() {
	}

	/**
	 *
	 * @param pageNum 页码
	 * @param limit 每页显示数
	 */
	public PageDto(Integer pageNum, Integer limit) {
		if (pageNum != null && pageNum > ZERO) {
			this.pageNum = pageNum;
		}
		if (limit != null && limit > ZERO) {
			this.limit = limit;
		}
		this.page = (this.pageNum - NUM) * this.limit;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		if (limit == null || limit <NUM) {
			return;
		}
		this.limit = limit;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		if (pageNum == null || pageNum <NUM) {
			return;
		}
		this.pageNum = pageNum;
	}

	public Integer getPage() {
		return pageNum.equals(NUM)  ? page : (this.getPageNum() - NUM) * this.getLimit();
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
