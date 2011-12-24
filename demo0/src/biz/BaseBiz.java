package biz;

import dao.ICommonDAO;

public abstract class BaseBiz {
	private ICommonDAO commonDAO;
	public ICommonDAO getCommonDAO() {
		return commonDAO;
	}
	public void setCommonDAO(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
}
