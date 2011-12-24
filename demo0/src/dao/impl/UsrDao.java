package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

import utils.HibernateUtil;
import utils.PageResult;
import dao.ICommonDAO;

public class UsrDao implements ICommonDAO {
	CommonDAO cd = new CommonDAO();

	@Override
	public Serializable add(Object o) {

		return cd.add(o);
	}

	@Override
	public void del(Class clazz, Serializable id) {
		cd.del(clazz, id);
	}

	@Override
	public void update(Object o) {
		cd.update(o);

	}

	@Override
	public Object find(Class clazz, Serializable id) {
		return cd.find(clazz, id);
	}

	@Override
	public List find(String hql) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		return session.createQuery(hql).list();
	}

	@Override
	public List find(String hql, PageResult pageResult) {

		return cd.find(hql, pageResult);
	}

	@Override
	public List find(DetachedCriteria dcr, PageResult pageResult) {

		return cd.find(dcr, pageResult);
	}

	@Override
	public Object execProc(String procName) {

		return cd.execProc(procName);
	}

}
