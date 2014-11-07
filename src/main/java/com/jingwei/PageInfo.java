package com.jingwei;

import java.io.Serializable;

/**
 * 
 * @author xianwen.tan
 * @date 2014-11-6
 *
 */
public class PageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 428358762315085602L;

	protected int pageNo = 0;
	protected int pageSize = 20;
	protected String sort;

	public PageInfo() {
	}

	public PageInfo(int pageNo) {
		this.pageNo = pageNo;
	}

	public PageInfo(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public PageInfo(int pageNo, int pageSize, String sort) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.sort = sort;
	}

	/**
	 * 返回当前页号，返回值一定是非负数
	 * 
	 * @return
	 */
	public int getPageNo() {
		return pageNo < 0 ? 0 : pageNo;
	}

	/**
	 * Returns the number of items to be returned.
	 * 
	 * @return the number of items of that page
	 */
	public int getPageSize() {
		return pageSize < 1 ? 1 : pageSize;
	}

	/**
	 * Returns the offset to be taken according to the underlying page and page
	 * size.
	 * 
	 * @return the offset to be taken
	 */
	public long getOffset() {
		long offset = ((long)pageSize) * pageNo;
		return offset < 0 ? 0 : offset;
	}

	/**
	 * 返回排序参数
	 * 
	 * @return
	 */
	public String getSort() {
		// TODO 防sql注入过滤
		return sort;

	}

	/**
	 * 取得下一页的分页信息
	 * 
	 * @return
	 */
	public PageInfo next() {
		return new PageInfo(getPageNo() + 1, getPageSize(), getSort());
	}

	/**
	 * 是否有上一页
	 * 
	 * @return
	 */
	public boolean hasPrevious() {
		return pageNo > 0;
	}

	/**
	 * 返回前一页，如果当前页是第一页，则返回当前页
	 * 
	 * @return
	 */
	public PageInfo previous() {
		if (hasPrevious()) {
			return new PageInfo(getPageNo() - 1, getPageSize(), getSort());
		}

		return this;
	}

	/**
	 * 取得第一页.
	 * 
	 * @return
	 */
	public PageInfo first() {
		return new PageInfo(0, getPageSize(), getSort());
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
