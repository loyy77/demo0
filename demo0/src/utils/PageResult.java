package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResult implements Serializable {
	private String orderBy = "";
	private String sort = "desc";
	private List list = new ArrayList(); //查询结果
	private int pageNo = 1; //实际页号
	private int pageSize = 10; //每页记录数
	private int recordCount = 0; //总记录数

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return (0==pageSize)?10:pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		int ret = (this.recordCount - 1) / this.getPageSize() + 1;
		ret = (ret<1)?1:ret;
		return ret;
	}
	public int getFirstRec()
	{
		int ret = (this.getPageNo()-1) * this.getPageSize();// + 1;
		ret = (ret < 1)?0:ret;
		return ret;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
}
