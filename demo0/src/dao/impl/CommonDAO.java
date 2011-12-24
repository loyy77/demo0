package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import utils.PageResult;
import dao.ICommonDAO;

public class CommonDAO extends HibernateDaoSupport implements ICommonDAO {

	/**
	 * 添加
	 */
	@Override
	public Serializable add(Object o) {
		return this.getHibernateTemplate().save(o);
	}
	/**
	 * 删除
	 */
	@Override
	public void del(Class clazz,Serializable id) {
		this.getHibernateTemplate().delete(this.find(clazz, id));
	}
	/**
	 * 调用存储
	 */
	@Override
	public Object execProc(String procName) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 根据Id查询
	 * @param clazz
	 * @param id
	 * @return
	 */
	@Override
	public Object find(Class clazz, Serializable id) {
		return this.getHibernateTemplate().get(clazz, id);
	}
	/**
	 * 带分页的查询(hql)
	 */
	@Override
	public List find(String hql, PageResult pageResult) {
		if (null==hql){
			return null;
		}
		Session session=this.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(pageResult.getFirstRec());
		query.setMaxResults(pageResult.getPageSize());
		List ret = query.list();
	
		/**
		 * 下面代码功能: 计算符合条件的记录总数
		 * "from PetInfo",
		 * "select pet from PetInfo pet",
		 * "from PetInfo order by petStrength",
		 * "select pet from PetInfo pet order by pet.petStrength",
		 * "from OrderDetail",
		 * "from Order ",
		 * "from Order as order"
		 */
		//删除select xx
		String t_hql=hql.toLowerCase();
		t_hql=hql.substring(t_hql.indexOf("from"));
		String t_hql_2=t_hql.toLowerCase();
		//删除order by
		int index_order=t_hql_2.indexOf(" order ");
		int index_by=t_hql_2.indexOf(" by ");
		if( index_order>-1 &&  index_by>-1 && (index_order<index_by) )
			t_hql=t_hql.substring(0, t_hql_2.indexOf(" order "));
		//连接聚合函数
		t_hql = "select count(*) " + t_hql;
		//计算符合条件的记录总数
		int recordCount=(Integer)session.createQuery(t_hql).uniqueResult();
		pageResult.setRecordCount(recordCount);
		return ret;
		
	}
	/**
	 * 不带分页的查询
	 */
	@Override
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * 更新
	 */
	@Override
	public void update(Object o) {
		this.getHibernateTemplate().update(o);
	}
	/**
	 * 带分页的查询(criteria)
	 */
	@Override
	public List find(DetachedCriteria dcr, PageResult pageResult) {
		List list = null;
		try {
			Criteria cr=dcr.getExecutableCriteria(this.getSession());
			cr.setFirstResult((pageResult.getPageNo() - 1) * pageResult.getPageSize());
			cr.setMaxResults(pageResult.getPageSize());
			list=cr.list();
			
			//计算页数
			cr.setProjection(Projections.rowCount());
			cr.setFirstResult(0); //必须将指针移回结果集开头.否则报NullPointer异常.
			int count = (Integer) cr.uniqueResult();
			pageResult.setRecordCount(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
		}

	
}
